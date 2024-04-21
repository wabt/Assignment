/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Address;
import model.User;

/**
 *
 * @author Admin
 */
public class AddressDAO extends DBContext {

    public void insert(Address a) {
        String sql = "INSERT INTO [dbo].[address]\n"
                + "           ([userID]\n"
                + "           ,[addressLine]\n"
                + "           ,[city]\n"
                + "           ,[country])\n"
                + "     VALUES(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, a.getUserID());
            st.setString(2, a.getAddressLine());
            st.setString(3, a.getCity());
            st.setString(4, a.getCountry());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Address a) {
        String sql = "UPDATE [dbo].[address]\n"
                + "   SET [userID] = ?\n"//1
                + "      ,[addressLine] = ?\n"//2
                + "      ,[city] = ?\n"//3
                + "      ,[country] = ?\n"//4
                + " WHERE userID = ?";//5
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a.getUserID());
            st.setString(2, a.getAddressLine());
            st.setString(3, a.getCity());
            st.setString(4, a.getCountry());
            st.setInt(5, a.getUserID());

            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public Address getAddessByUserID(int userID) {
        String sql = "SELECT [addressID]\n"//1
                + "      ,[userID]\n"//2
                + "      ,[addressLine]\n"//3
                + "      ,[city]\n"//4
                + "      ,[country]\n"//5
                + "  FROM [dbo].[address]\n"
                + "  WHERE userID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Address a = new Address();
                a.setAddressID(rs.getInt(1));
                a.setUserID(rs.getInt(2));
                a.setAddressLine(rs.getString(3));
                a.setCity(rs.getString(4));
                a.setCountry(rs.getString(5));

                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void delete(int userID) {
        String sql = "DELETE FROM [dbo].[address]\n"
                + "      WHERE userID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userID);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        AddressDAO adb = new AddressDAO();
        System.out.println(adb.getAddessByUserID(8));
    }
}
