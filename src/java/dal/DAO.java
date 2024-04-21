/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.User;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT [userID]\n"//1
                + "      ,[userName]\n"//2
                + "      ,[password]\n"//3
                + "      ,[email]\n"//4
                + "      ,[firstName]\n"//5
                + "      ,[lastName]\n"//6
                + "      ,[dob]\n"//7
                + "      ,[sex]\n"//8
                + "      ,[role]\n"//9
                + "      ,[phone]\n"//10
                + "  FROM [dbo].[user]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt(1));
                u.setUserName(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setFirstName(rs.getString(5));
                u.setLastName(rs.getString(6));
                u.setDob(rs.getDate(7));
                u.setSex(rs.getInt(8));
                u.setRole(rs.getInt(9));
                u.setPhone(rs.getInt(10));

                list.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public User check(String username, String password) {
        String sql = "SELECT [userID]\n"//1
                + "      ,[userName]\n"//2
                + "      ,[password]\n"//3
                + "      ,[email]\n"//4
                + "      ,[firstName]\n"//5
                + "      ,[lastName]\n"//6
                + "      ,[dob]\n"//7
                + "      ,[sex]\n"//8
                + "      ,[role]\n"//9
                + "      ,[phone]\n"//10
                + "  FROM [dbo].[user]\n"
                + "  WHERE userName=? AND [password]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt(1));
                u.setUserName(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setFirstName(rs.getString(5));
                u.setLastName(rs.getString(6));
                u.setDob(rs.getDate(7));
                u.setSex(rs.getInt(8));
                u.setRole(rs.getInt(9));
                u.setPhone(rs.getInt(10));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

//    public User check2(String username, String password) {
//        String sql = "SELECT [userName]\n"//1
//                + "      ,[password]\n"//2
//                + "  FROM [dbo].[user]\n"
//                + "  WHERE userName=? AND password=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, username);
//            st.setString(2, password);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                User u = new User();
//                u.setUserName(rs.getString(1));
//                u.setPassword(rs.getString(2));
//
//                return u;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
    public User checkUserName(String username) {
        String sql = "SELECT [userID]\n"//1
                + "      ,[userName]\n"//2
                + "      ,[password]\n"//3
                + "      ,[email]\n"//4
                + "      ,[firstName]\n"//5
                + "      ,[lastName]\n"//6
                + "      ,[dob]\n"//7
                + "      ,[sex]\n"//8
                + "      ,[role]\n"//9
                + "      ,[phone]\n"//10
                + "  FROM [dbo].[user]\n"
                + "  WHERE userName=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt(1));
                u.setUserName(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setFirstName(rs.getString(5));
                u.setLastName(rs.getString(6));
                u.setDob(rs.getDate(7));
                u.setSex(rs.getInt(8));
                u.setRole(rs.getInt(9));
                u.setPhone(rs.getInt(10));
                return u;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public User checkEmail(String email) {
        String sql = "SELECT [userID]\n"//1
                + "      ,[userName]\n"//2
                + "      ,[password]\n"//3
                + "      ,[email]\n"//4
                + "      ,[firstName]\n"//5
                + "      ,[lastName]\n"//6
                + "      ,[dob]\n"//7
                + "      ,[sex]\n"//8
                + "      ,[role]\n"//9
                + "      ,[phone]\n"//10
                + "  FROM [dbo].[user]\n"
                + "  WHERE [email]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt(1));
                u.setUserName(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setFirstName(rs.getString(5));
                u.setLastName(rs.getString(6));
                u.setDob(rs.getDate(7));
                u.setSex(rs.getInt(8));
                u.setRole(rs.getInt(9));
                u.setPhone(rs.getInt(10));
                return u;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public void insertUser(User u) {
        String sql = "INSERT INTO [dbo].[user]\n"
                + "           ([userName]\n"
                + "           ,[password]\n"
                + "           ,[email]\n"
                + "           ,[role])\n"
                + "     VALUES (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, u.getUserName());
            st.setString(2, u.getPassword());
            st.setString(3, u.getEmail());
            st.setInt(4, u.getRole());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateUser(User u) {
        String sql = "UPDATE [dbo].[user]\n"
                + "   SET [firstName] = ?\n"//1
                + "      ,[lastName] = ?\n"//2
                + "      ,[dob] = ?\n"//3
                + "      ,[sex] = ?\n"//4
                + "      ,[phone] = ?\n"//5
                + " WHERE [userName]=?";//6
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getFirstName());
            st.setString(2, u.getLastName());
            java.util.Date utilDate = u.getDob();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            st.setDate(3, sqlDate);
            st.setInt(4, u.getSex());
            st.setInt(5, u.getPhone());
            st.setString(6, u.getUserName());
            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void updateUserAdmin(User u) {
        String sql = "UPDATE [dbo].[user]\n"
                + "   SET [firstName] =?\n"//1
                + "      ,[lastName] =?\n"//2
                + "      ,[dob] =?\n"//3
                + "      ,[sex] =?\n"//4
                + "      ,[role] =?\n"//5
                + "      ,[phone] =?\n"//6
                + " WHERE userName=?";//7
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getFirstName());
            st.setString(2, u.getLastName());
            java.util.Date utilDate = u.getDob();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            st.setDate(3, sqlDate);
            st.setInt(4, u.getSex());
            st.setInt(5, u.getRole());
            st.setInt(6, u.getPhone());
            st.setString(7, u.getUserName());
            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void changePassword(User u) {
        String sql = "UPDATE [dbo].[user]\n"
                + "   SET [password] = ?\n"//1
                + " WHERE userID = ?";//2
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getPassword());
            st.setInt(2, u.getUserID());
            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void delete(int userID) {
        String sql = "DELETE FROM [dbo].[user]\n"
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
        DAO d = new DAO();
        System.out.println(d.checkEmail("buianhtu293@gmail.com"));
    }
}
