/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoryDAO;
import dal.DAO;
import dal.ProductDAO;
import dto.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ShopServlet extends HttpServlet {

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
            out.println("<title>Servlet ShopServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopServlet at " + request.getContextPath() + "</h1>");
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
        String categoryID_raw = request.getParameter("categoryID");
        int categoryID;

        try {
            if (categoryID_raw == null || categoryID_raw.equals("")) {
                CategoryDAO cdb = new CategoryDAO();
                ProductDAO pdb = new ProductDAO();
                List listC = new ArrayList();
                List listP1 = new ArrayList();
                listC = cdb.countProductInCategory();
                listP1 = pdb.getAllDTO();

                int page, numperpage = 9;
                int size = listP1.size();
                int num = (size%9==0?(size/9):((size/9)+1));
                String xpage = request.getParameter("page");
                if(xpage==null){
                    page=1;
                }else{
                    page = Integer.parseInt(xpage);
                }
                int start, end;
                start = (page-1)*numperpage;
                end = Math.min(page*numperpage, size);
                List<ProductDTO> listP = pdb.getListByPage(listP1, start, end);
                request.setAttribute("page", page);
                request.setAttribute("num", num);

                request.setAttribute("listC", listC);
                request.setAttribute("listP", listP);
                request.getRequestDispatcher("shop.jsp").forward(request, response);
            } else {
                categoryID = Integer.parseInt(categoryID_raw);
                CategoryDAO cdb = new CategoryDAO();
                ProductDAO pdb = new ProductDAO();
                List listC = new ArrayList();
                List listP1 = new ArrayList();
                listC = cdb.countProductInCategory();
                listP1 = pdb.getProductByCategoryID(categoryID);
                
                int page, numperpage = 9;
                int size = listP1.size();
                int num = (size%9==0?(size/9):((size/9)+1));
                String xpage = request.getParameter("page");
                if(xpage==null){
                    page=1;
                }else{
                    page = Integer.parseInt(xpage);
                }
                int start, end;
                start = (page-1)*numperpage;
                end = Math.min(page*numperpage, size);
                List<ProductDTO> listP = pdb.getListByPage(listP1, start, end);
                request.setAttribute("page", page);
                request.setAttribute("num", num);
                
                request.setAttribute("listC", listC);
                request.setAttribute("listP", listP);
                request.getRequestDispatcher("shop.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {

        }
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

        String search = request.getParameter("search");
        String fruitlist = request.getParameter("fruitlist");
        String price_raw = request.getParameter("price");
        String color = request.getParameter("color");
        float price = 0;

        try {
            if (fruitlist == null) {
                CategoryDAO cdb = new CategoryDAO();
                ProductDAO pdb = new ProductDAO();
                List listC = new ArrayList();
                List listP1 = new ArrayList();
                listC = cdb.countProductInCategory();
                listP1 = pdb.getProductBySearch(search);
                
                int page, numperpage = 9;
                int size = listP1.size();
                int num = (size%9==0?(size/9):((size/9)+1));
                String xpage = request.getParameter("page");
                if(xpage==null){
                    page=1;
                }else{
                    page = Integer.parseInt(xpage);
                }
                int start, end;
                start = (page-1)*numperpage;
                end = Math.min(page*numperpage, size);
                List<ProductDTO> listP = pdb.getListByPage(listP1, start, end);
                request.setAttribute("page", page);
                request.setAttribute("num", num);
                
                request.setAttribute("listC", listC);
                request.setAttribute("listP", listP);
                request.getRequestDispatcher("shop.jsp").forward(request, response);
            } else {
                price = Float.parseFloat(price_raw);
                CategoryDAO cdb = new CategoryDAO();
                ProductDAO pdb = new ProductDAO();
                List listC = new ArrayList();
                List listP1 = new ArrayList();
                listC = cdb.countProductInCategory();
                listP1 = pdb.getProduct(search, fruitlist, price, color);
                
                int page, numperpage = 9;
                int size = listP1.size();
                int num = (size%9==0?(size/9):((size/9)+1));
                String xpage = request.getParameter("page");
                if(xpage==null){
                    page=1;
                }else{
                    page = Integer.parseInt(xpage);
                }
                int start, end;
                start = (page-1)*numperpage;
                end = Math.min(page*numperpage, size);
                List<ProductDTO> listP = pdb.getListByPage(listP1, start, end);
                request.setAttribute("page", page);
                request.setAttribute("num", num);
                
                request.setAttribute("listC", listC);
                request.setAttribute("listP", listP);
                request.getRequestDispatcher("shop.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {

        }

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
