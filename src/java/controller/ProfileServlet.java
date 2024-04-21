/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AddressDAO;
import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Address;
import model.User;

/**
 *
 * @author Admin
 */
public class ProfileServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfileServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String sex_raw = request.getParameter("sex");
        String phone_raw = request.getParameter("phone");
        String dob_raw = request.getParameter("dob");

        String userID_raw = request.getParameter("userID");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String addressLine = request.getParameter("addressLine");

        HttpSession session = request.getSession();
        DAO d = new DAO();
        AddressDAO adb = new AddressDAO();
        int sex;
        int phone;
        int userID;
        try {
            userID = Integer.parseInt(userID_raw);
            Address a = new Address();
            a.setUserID(userID);
            a.setCountry(country);
            a.setCity(city);
            a.setAddressLine(addressLine);
            if(adb.getAddessByUserID(userID)==null){
                adb.insert(a);
            }else{
                adb.update(a);
            }
            session.setAttribute("address", a);
            
            if (sex_raw==null || sex_raw.equals("")
                    || phone_raw==null || phone_raw.equals("")
                    || dob_raw==null || dob_raw.equals("")
                    || firstName==null || firstName.equals("")
                    || lastName==null ||lastName.equals("")) {
                request.setAttribute("error", "Attribute is Invalid!");
                
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date utilDate = sdf.parse(dob_raw);
                java.sql.Date dob = new java.sql.Date(utilDate.getTime());
                sex = Integer.parseInt(sex_raw);
                phone = Integer.parseInt(phone_raw);
                
                User u = new User();
                u.setUserName(userName);
                u.setFirstName(firstName);
                u.setLastName(lastName);
                u.setDob(dob);
                u.setSex(sex);
                u.setPhone(phone);
                d.updateUser(u);
                User u1 = d.checkUserName(userName);
                session.setAttribute("account", u1);
                
            }
        } catch (ParseException e) {

        }
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
