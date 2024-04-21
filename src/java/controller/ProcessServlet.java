/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Item;
import model.Product;
import model.User;

/**
 *
 * @author Admin
 */
public class ProcessServlet extends HttpServlet {

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
            out.println("<title>Servlet ProcessServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        ProductDAO pdb = new ProductDAO();
        List<Product> list = pdb.getAll();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }

        User u = (User) session.getAttribute("account");
        Cart cart = new Cart(txt, list);
        String num_raw = request.getParameter("num");
        String id_raw = request.getParameter("id");
        int id, num = 0;
        try {
            id = Integer.parseInt(id_raw);
            Product p = pdb.getProductByID(id);
            int numStore = p.getQuantity_in_stock();
            num = Integer.parseInt(num_raw);
            if (num == -1 && (cart.getQuantityById(id,u.getUserID()) <= 1)) {
                cart.removeItem(id, u.getUserID());
            } else {
                if ((num == 1) && cart.getQuantityById(id, u.getUserID()) >= numStore) {
                    num = 0;
                } else {
                    float price = p.getPrice();
                    Item t = new Item(p, num, price, u.getUserID());
//                    Item t = new Item(p, num, price);
                    cart.addItem(t);
                }
            }

        } catch (NumberFormatException e) {

        }

        List<Item> items = cart.getItems();
//        List<User> user = new ArrayList<>();
//        String[] s = txt.split("z");
//        for (String i : s) {
//            String[] n = i.split(":");
//            int userid_txt = Integer.parseInt(n[0]);
//            int id_txt = Integer.parseInt(n[1]);
//            int quantity = Integer.parseInt(n[2]);
//            User u1 = new User(userid_txt);
//            user.add(u1);
//        }
        txt = "";

        if (items.size() > 0) {
            txt = items.get(0).getUserID() + ":"
                    + items.get(0).getProduct().getProductID() + ":"
                    + items.get(0).getQuantity();
            for (int i = 1; i < items.size(); i++) {
                txt += "z" + items.get(i).getUserID() + ":"
                        + items.get(i).getProduct().getProductID() + ":"
                        + items.get(i).getQuantity();
            }
        }
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(2 * 24 * 60 * 60);
        response.addCookie(c);
        cart = new Cart(txt, list, u.getUserID());
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        ProductDAO pdb = new ProductDAO();
        List<Product> list = pdb.getAll();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        
        String userid = request.getParameter("userid");
        String id = request.getParameter("id");
        String[] ids = txt.split("z");
        String out = "";
        for (int i = 0; i < ids.length; i++) {
            String[] s = ids[i].split(":");
            if (!s[1].equals(id) || !s[0].equals(userid)) {
                if (out.isEmpty()) {
                    out = ids[i];
                } else {
                    out += "z" + ids[i];
                }
            }
        }
        if (!out.isEmpty()) {
            Cookie c = new Cookie("cart", out);
            c.setMaxAge(2 * 24 * 60 * 60);
            response.addCookie(c);
        }

        User u = (User) session.getAttribute("account");
        Cart cart = new Cart(out, list, u.getUserID());
        request.setAttribute("cart", cart);
        cart.removeItem(Integer.parseInt(id), u.getUserID());
        request.getRequestDispatcher("cart.jsp").forward(request, response);
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
