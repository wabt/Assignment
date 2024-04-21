/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dto.CategoryDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author Admin
 */
public class CategoryDAO extends DBContext {

    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT [categoryID]\n"//1
                + "      ,[categoryName]\n"//2
                + "      ,[category_img]\n"//3
                + "  FROM [dbo].[category]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCategoryID(rs.getInt(1));
                c.setCategoryName(rs.getString(2));
                c.setCategory_img(rs.getString(3));

                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<CategoryDTO> countProductInCategory() {
        List<CategoryDTO> list = new ArrayList<>();
        String sql = "SELECT C.[categoryID]\n"//1
                + "		,C.categoryName\n"//2
                + "	  ,COUNT(C.categoryID)\n"//3
                + "  FROM [dbo].[product] AS [P]\n"
                + "  INNER JOIN [dbo].[category] AS [C]\n"
                + "  ON P.categoryID = C.categoryID\n"
                + "  GROUP BY C.categoryID,C.categoryName";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDTO c = new CategoryDTO();
                c.setCategoryID(rs.getInt(1));
                c.setCategoryName(rs.getString(2));
                c.setCount(rs.getInt(3));

                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void insert(Category c) {
        String sql = "INSERT INTO [dbo].[category]\n"
                + "           ([categoryName]\n"
                + "           ,[category_img])\n"
                + "     VALUES (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getCategoryName());
            st.setString(2, c.getCategory_img());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Category getCategoryByName(String categoryName) {
        String sql = "SELECT [categoryID]\n"//1
                + "      ,[categoryName]\n"//2
                + "      ,[category_img]\n"//3
                + "  FROM [dbo].[category]\n"
                + "  WHERE categoryName = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, categoryName);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category();
                c.setCategoryID(rs.getInt(1));
                c.setCategoryName(rs.getString(2));
                c.setCategory_img(rs.getString(3));

                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void delete(int categoryID) {
        String sql = "DELETE FROM [dbo].[category]\n"
                + "      WHERE categoryID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, categoryID);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Category c) {
        String sql = "UPDATE [dbo].[category]\n"
                + "   SET [categoryName] = ?\n"//1
                + "      ,[category_img] = ?\n"//2
                + " WHERE categoryID=?";//3
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCategoryName());
            st.setString(2, c.getCategory_img());
            st.setInt(3, c.getCategoryID());
            st.executeUpdate();
        } catch (SQLException e) {

        }
    }
}
