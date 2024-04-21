/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import util.Email;
import util.Encrypt;

/**
 *
 * @author Admin
 */
public class VerifyServlet extends HttpServlet {

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
            out.println("<title>Servlet VerifyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VerifyServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("verify.jsp").forward(request, response);
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
        String email = request.getParameter("email");
        String user = request.getParameter("username");
        String pass_raw = request.getParameter("pass");
        String pass = Encrypt.toSHA1(pass_raw);

        if (!isValidPassword(pass_raw)) {
            request.setAttribute("error", "Password must be at least 8 characters long and include letters, numbers, and special characters.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

       
        DAO d = new DAO();
        User u = new User(user, pass, email, 2);

        if (email == null || email.equals("")
                || user == null || user.equals("")
                || pass == null || pass.equals("")) {
            request.setAttribute("error", "UserName or Password or Email invalid!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (d.checkUserName(user) != null) {
            request.setAttribute("existed", "User Name is Existed!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (d.checkEmail(email) != null) {
            request.setAttribute("existed", "E-mail is Existed!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            String code = Email.getRandomNumber();
            Email.sendEmail(email, "Enter This Code To Verify Your Email", code);
            HttpSession session = request.getSession();
            session.setAttribute("signUpAccount", u);
            session.setAttribute("code", code);
            request.getRequestDispatcher("verify.jsp").forward(request, response);
        }
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 8 && password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$");
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
