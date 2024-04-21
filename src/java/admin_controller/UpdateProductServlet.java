/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package admin_controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;

/**
 *
 * @author Admin
 */
public class UpdateProductServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet UpdateProductServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProductServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String productID_raw = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String price_raw = request.getParameter("price");
        String description = request.getParameter("description");
        String color = request.getParameter("color");
        String quantity_in_stock_raw = request.getParameter("quantity_in_stock");
        String productImg = request.getParameter("productImg");
        String categoryID_raw = request.getParameter("categoryID");

        int productID;
        float price;
        int quantity_in_stock;
        int categoryID;

        try {
            productID = Integer.parseInt(productID_raw);
            price = Float.parseFloat(price_raw);
            quantity_in_stock = Integer.parseInt(quantity_in_stock_raw);
            categoryID = Integer.parseInt(categoryID_raw);

            Product p = new Product(productID, productName, price, description, color, quantity_in_stock, productImg, categoryID);
            ProductDAO pdb = new ProductDAO();
            CategoryDAO cdb = new CategoryDAO();
            
            if (pdb.getProductByName(productName) == null || pdb.getProductByName(productName).getProductName().equals(productName)) {
                pdb.update(p);
                List list = pdb.getAllDTO();
                List listC = cdb.getAll();
                request.setAttribute("list", list);
                request.setAttribute("listC", listC);
                request.getRequestDispatcher("a_product.jsp").forward(request, response);
            }else{
                List list = pdb.getAllDTO();
                List listC = cdb.getAll();
                request.setAttribute("list", list);
                request.setAttribute("listC", listC);
                request.setAttribute("error", "Product Name is Existed!");
                request.getRequestDispatcher("a_product.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {

        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
