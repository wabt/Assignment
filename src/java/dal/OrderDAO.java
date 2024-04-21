/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dto.OrderDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Address;
import model.Cart;
import model.Item;
import model.Product;
import model.User;

/**
 *
 * @author Admin
 */
public class OrderDAO extends DBContext {

    public void addOrder(User u, Cart cart, Address a) {
        LocalDate curDate = LocalDate.now();
        Date date = convertToDateViaInstant(curDate);
        try {
            //add shop_order
            String sql = "INSERT INTO [dbo].[shop_order]\n"
                    + "           ([userID]\n"//1
                    + "           ,[addressID]\n"//2
                    + "           ,[orderTotal]\n"//3
                    + "           ,[orderDate]\n"//4
                    + "           ,[recipient]\n"//5
                    + "           ,[recipientPhone])\n"//6
                    + "     VALUES (?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, u.getUserID());
            st.setInt(2, a.getAddressID());
            st.setFloat(3, cart.getTotalMoney());
            java.util.Date utilDate = date;
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            st.setDate(4, sqlDate);
            st.setString(5, u.getFirstName() + " " + u.getLastName());
            st.setString(6, String.valueOf(u.getPhone()));
            st.executeUpdate();

            //Lay id order vua add
            String sql1 = "SELECT TOP 1 [shopOrderID]\n"//1
                    + "  FROM [dbo].[shop_order]\n"
                    + "  ORDER BY shopOrderID DESC";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();

            //Add vao order_details
            if (rs.next()) {
                int shopOrderID = rs.getInt(1);
                for (Item i : cart.getItems()) {
                    String sql2 = "INSERT INTO [dbo].[order_details]\n"
                            + "           ([shopOrderID]\n"//1
                            + "           ,[productID]\n"//2
                            + "           ,[quantity]\n"//3
                            + "           ,[price])\n"//4
                            + "     VALUES (?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, shopOrderID);
                    st2.setInt(2, i.getProduct().getProductID());
                    st2.setInt(3, i.getQuantity());
                    st2.setFloat(4, i.getPrice());
                    st2.executeUpdate();
                }
            }

            //Cap nhat so luong san pham
            String sql3 = "UPDATE [dbo].[product]\n"
                    + "   SET [quantity_in_stock] = [quantity_in_stock]-?\n"
                    + " WHERE productID=?";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            for (Item i : cart.getItems()) {
                st3.setInt(1, i.getQuantity());
                st3.setInt(2, i.getProduct().getProductID());
                st3.executeUpdate();
            }
        } catch (SQLException e) {

        }
    }

    public static Date convertToDateViaInstant(LocalDate localDate) {
        // Convert LocalDate to ZonedDateTime at the start of the day in system default timezone
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());

        // Convert ZonedDateTime to Date
        return Date.from(zonedDateTime.toInstant());
    }

    public List<OrderDTO> getAll() {
        List<OrderDTO> list = new ArrayList<>();
        String sql = "SELECT O.[shopOrderID]\n"//1
                + "      ,O.[userID]\n"//2
                + "      ,O.[addressID]\n"//3
                + "      ,O.[orderTotal]\n"//4
                + "      ,O.[orderDate]\n"//5
                + "      ,O.[recipient]\n"//6
                + "      ,O.[recipientPhone]\n"//7
                + "	  ,D.quantity\n"//8
                + "	  ,D.price\n"//9
                + "	  ,P.productName\n"//10
                + "  FROM [dbo].[shop_order] AS [O]\n"
                + "  JOIN [dbo].[order_details] AS [D]\n"
                + "  ON O.shopOrderID = D.shopOrderID\n"
                + "  JOIN [dbo].[product] AS [P]\n"
                + "  ON D.productID = P.productID";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderDTO o = new OrderDTO();
                o.setShopOrderID(rs.getInt(1));
                o.setUserID(rs.getInt(2));
                o.setAddressID(rs.getInt(3));
                o.setOrderTotal(rs.getFloat(4));
                o.setOrderDate(rs.getDate(5));
                o.setRecipient(rs.getString(6));
                o.setRecipientPhone(rs.getString(7));
                o.setQuantity(rs.getInt(8));
                o.setPrice(rs.getFloat(9));
                o.setProductName(rs.getString(10));

                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
