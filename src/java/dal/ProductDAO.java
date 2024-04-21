/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dto.ProductDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductDAO extends DBContext {

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT [productID]\n"//1
                + "      ,[productName]\n"//2
                + "      ,[price]\n"//3
                + "      ,[description]\n"//4
                + "      ,[color]\n"//5
                + "      ,[quantity_in_stock]\n"//6
                + "      ,[product_img]\n"//7
                + "      ,[categoryID]\n"//8
                + "  FROM [dbo].[product]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setPrice(rs.getFloat(3));
                p.setDescription(rs.getString(4));
                p.setColor(rs.getString(5));
                p.setQuantity_in_stock(rs.getInt(6));
                p.setProduct_img(rs.getString(7));
                p.setCategoryID(rs.getInt(8));

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<ProductDTO> getAllDTO() {
        List<ProductDTO> list = new ArrayList<>();
        String sql = "SELECT P.[productID]\n"//1
                + "      ,P.[productName]\n"//2
                + "      ,P.[price]\n"//3
                + "      ,P.[description]\n"//4
                + "      ,P.[color]\n"//5
                + "      ,P.[quantity_in_stock]\n"//6
                + "      ,P.[product_img]\n"//7
                + "      ,P.[categoryID]\n"//8
                + "	  ,C.categoryName\n"//9
                + "  FROM [dbo].[product] AS [P]\n"
                + "  JOIN [dbo].[category] AS [C]\n"
                + "  ON P.categoryID = C.categoryID";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDTO p = new ProductDTO();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setPrice(rs.getFloat(3));
                p.setDescription(rs.getString(4));
                p.setColor(rs.getString(5));
                p.setQuantity_in_stock(rs.getInt(6));
                p.setProduct_img(rs.getString(7));
                p.setCategoryID(rs.getInt(8));
                p.setCategoryName(rs.getString(9));

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<ProductDTO> getProductByCategoryID(int categoryID) {
        List<ProductDTO> list = new ArrayList<>();
        String sql = "SELECT P.[productID]\n"
                + "      ,P.[productName]\n"
                + "      ,P.[price]\n"
                + "      ,P.[description]\n"
                + "      ,P.[color]\n"
                + "      ,P.[quantity_in_stock]\n"
                + "      ,P.[product_img]\n"
                + "      ,P.[categoryID]\n"
                + "	  ,C.categoryName\n"
                + "  FROM [dbo].[product] AS [P]\n"
                + "  JOIN [dbo].[category] AS [C]\n"
                + "  ON P.categoryID = C.categoryID\n"
                + "  WHERE P.categoryID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, categoryID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDTO p = new ProductDTO();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setPrice(rs.getFloat(3));
                p.setDescription(rs.getString(4));
                p.setColor(rs.getString(5));
                p.setQuantity_in_stock(rs.getInt(6));
                p.setProduct_img(rs.getString(7));
                p.setCategoryID(rs.getInt(8));
                p.setCategoryName(rs.getString(9));

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<ProductDTO> getProduct(String search, String fruitlist, float price, String color) {
        List<ProductDTO> list = new ArrayList<>();
        String sql = "SELECT P.[productID]\n"
                + "      ,P.[productName]\n"
                + "      ,P.[price]\n"
                + "      ,P.[description]\n"
                + "      ,P.[color]\n"
                + "      ,P.[quantity_in_stock]\n"
                + "      ,P.[product_img]\n"
                + "      ,P.[categoryID]\n"
                + "	  ,C.categoryName\n"
                + "  FROM [dbo].[product] AS [P]\n"
                + "  JOIN [dbo].[category] AS [C]\n"
                + "  ON P.categoryID = C.categoryID\n"
                + "  WHERE 1=1 ";
        if (!fruitlist.equals("b")) {
            if (search != null) {
                sql += " AND P.productName LIKE '%" + search + "%'";
            }
            if (price != 0) {
                sql += " AND P.price <= " + price;
            }
            if (color != null) {
                sql += " AND P.color = '" + color + "'";
            }
            if (fruitlist.equals("c")) {
                sql += "\n ORDER BY P.productName ASC";
            }
            if (fruitlist.equals("d")) {
                sql += "\n ORDER BY P.productName DESC";
            }
            if (fruitlist.equals("e")) {
                sql += "\n ORDER BY P.price DESC";
            }
            if (fruitlist.equals("f")) {
                sql += "\n ORDER BY P.price ASC";
            }
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, categoryID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDTO p = new ProductDTO();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setPrice(rs.getFloat(3));
                p.setDescription(rs.getString(4));
                p.setColor(rs.getString(5));
                p.setQuantity_in_stock(rs.getInt(6));
                p.setProduct_img(rs.getString(7));
                p.setCategoryID(rs.getInt(8));
                p.setCategoryName(rs.getString(9));

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ProductDTO getProductByProductID(int productID) {
        String sql = "SELECT P.[productID]\n"//1
                + "      ,P.[productName]\n"//2
                + "      ,P.[price]\n"//3
                + "      ,P.[description]\n"//4
                + "      ,P.[color]\n"//5
                + "      ,P.[quantity_in_stock]\n"//6
                + "      ,P.[product_img]\n"//7
                + "      ,P.[categoryID]\n"//8
                + "	  ,C.categoryName\n"//9
                + "  FROM [dbo].[product] AS [P]\n"
                + "  JOIN [dbo].[category] AS [C]\n"
                + "  ON P.categoryID = C.categoryID\n"
                + "  WHERE P.productID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, productID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ProductDTO p = new ProductDTO();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setPrice(rs.getFloat(3));
                p.setDescription(rs.getString(4));
                p.setColor(rs.getString(5));
                p.setQuantity_in_stock(rs.getInt(6));
                p.setProduct_img(rs.getString(7));
                p.setCategoryID(rs.getInt(8));
                p.setCategoryName(rs.getString(9));

                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public Product getProductByID(int productID) {
        String sql = "SELECT P.[productID]\n"//1
                + "      ,P.[productName]\n"//2
                + "      ,P.[price]\n"//3
                + "      ,P.[description]\n"//4
                + "      ,P.[color]\n"//5
                + "      ,P.[quantity_in_stock]\n"//6
                + "      ,P.[product_img]\n"//7
                + "      ,P.[categoryID]\n"//8
                + "	  ,C.categoryName\n"//9
                + "  FROM [dbo].[product] AS [P]\n"
                + "  JOIN [dbo].[category] AS [C]\n"
                + "  ON P.categoryID = C.categoryID\n"
                + "  WHERE P.productID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, productID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setPrice(rs.getFloat(3));
                p.setDescription(rs.getString(4));
                p.setColor(rs.getString(5));
                p.setQuantity_in_stock(rs.getInt(6));
                p.setProduct_img(rs.getString(7));
                p.setCategoryID(rs.getInt(8));

                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    

    public List<ProductDTO> getProductBySearch(String search) {
        List<ProductDTO> list = new ArrayList<>();
        String sql = "SELECT P.[productID]\n"
                + "      ,P.[productName]\n"
                + "      ,P.[price]\n"
                + "      ,P.[description]\n"
                + "      ,P.[color]\n"
                + "      ,P.[quantity_in_stock]\n"
                + "      ,P.[product_img]\n"
                + "      ,P.[categoryID]\n"
                + "	  ,C.categoryName\n"
                + "  FROM [dbo].[product] AS [P]\n"
                + "  JOIN [dbo].[category] AS [C]\n"
                + "  ON P.categoryID = C.categoryID\n"
                + "  WHERE 1=1 ";
        if (search != null) {
            sql += " AND P.productName LIKE '%" + search + "%'";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, categoryID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDTO p = new ProductDTO();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setPrice(rs.getFloat(3));
                p.setDescription(rs.getString(4));
                p.setColor(rs.getString(5));
                p.setQuantity_in_stock(rs.getInt(6));
                p.setProduct_img(rs.getString(7));
                p.setCategoryID(rs.getInt(8));
                p.setCategoryName(rs.getString(9));

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<ProductDTO> getListByPage(List<ProductDTO> list, int start, int end) {
        ArrayList<ProductDTO> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public void deleteProductByCategoryID(int categoryID) {
        String sql = "DELETE FROM [dbo].[product]\n"
                + "      WHERE categoryID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, categoryID);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Product c) {
        String sql = "INSERT INTO [dbo].[product]\n"
                + "           ([productName]\n"
                + "           ,[price]\n"
                + "           ,[description]\n"
                + "           ,[color]\n"
                + "           ,[quantity_in_stock]\n"
                + "           ,[product_img]\n"
                + "           ,[categoryID])\n"
                + "     VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getProductName());
            st.setFloat(2, c.getPrice());
            st.setString(3, c.getDescription());
            st.setString(4, c.getColor());
            st.setInt(5, c.getQuantity_in_stock());
            st.setString(6, c.getProduct_img());
            st.setInt(7, c.getCategoryID());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int productID) {
        String sql = "DELETE FROM [dbo].[product]\n"
                + "      WHERE productID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, productID);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Product c) {
        String sql = "UPDATE [dbo].[product]\n"
                + "   SET [productName] = ?\n"//1
                + "      ,[price] = ?\n"//2
                + "      ,[description] = ?\n"//3
                + "      ,[color] = ?\n"//4
                + "      ,[quantity_in_stock] = ?\n"//5
                + "      ,[product_img] = ?\n"//6
                + "      ,[categoryID] = ?\n"//7
                + " WHERE productID=?";//8
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getProductName());
            st.setFloat(2, c.getPrice());
            st.setString(3, c.getDescription());
            st.setString(4, c.getColor());
            st.setInt(5, c.getQuantity_in_stock());
            st.setString(6, c.getProduct_img());
            st.setInt(7, c.getCategoryID());
            st.setInt(8, c.getProductID());

            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public Product getProductByName(String productName) {
        String sql = "SELECT [productID]\n"//1
                + "      ,[productName]\n"//2
                + "      ,[price]\n"//3
                + "      ,[description]\n"//4
                + "      ,[color]\n"//5
                + "      ,[quantity_in_stock]\n"//6
                + "      ,[product_img]\n"//7
                + "      ,[categoryID]\n"//8
                + "  FROM [dbo].[product]\n"
                + "  WHERE productName=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, productName);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setPrice(rs.getFloat(3));
                p.setDescription(rs.getString(4));
                p.setColor(rs.getString(5));
                p.setQuantity_in_stock(rs.getInt(6));
                p.setProduct_img(rs.getString(7));
                p.setCategoryID(rs.getInt(8));
                
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        ProductDAO p = new ProductDAO();
        System.out.println(p.getProductByName("apple"));
    }
}
