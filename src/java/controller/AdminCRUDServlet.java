/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDao;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
public class AdminCRUDServlet extends HttpServlet {

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
            
            int productID = Integer.parseInt(request.getParameter("id"));
            Product product = new ProductDao().getOne(productID);
            request.setAttribute("ProductID", productID);
            request.setAttribute("Name", product.getName());
            request.setAttribute("BrandID", product.getBrandId());
            request.setAttribute("CategoryID", product.getCategoryId());
            request.setAttribute("Price", product.getPrice());
            request.setAttribute("Quantity", product.getQuantity());
            request.setAttribute("Img_link", product.getImgName());
            request.setAttribute("Description", product.getDescription());
            request.setAttribute("Note", product.getNote());
            request.setAttribute("Status", product.getStatus());
            request.getRequestDispatcher("adminEdit.jsp").forward(request, response);
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
        processRequest(request, response);
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
        
        int productID = Integer.parseInt(request.getParameter("ProductID"));
        String name = request.getParameter("Name");
        int brandID = Integer.parseInt(request.getParameter("BrandID"));
        int categoryID = Integer.parseInt(request.getParameter("CategoryID"));
        double price = Double.parseDouble(request.getParameter("Price"));
        int quantity = Integer.parseInt(request.getParameter("Quantity"));
        String imgLink = request.getParameter("Img_link");
        String description = request.getParameter("Description");
        String note = request.getParameter("Note");
        int status = Integer.parseInt(request.getParameter("Status"));
        Product product = Product.builder()
                        .id(productID)
                        .brandId(brandID)
                        .categoryId(categoryID)
                        .name(name)
                        .price(price)
                        .quantity(quantity)
                        .imgName(imgLink)
                        .description(description)
                        .note(note)
                        .status(status)
                        .build();
        ProductDao t = new ProductDao();
        t.update(productID, product);
        response.sendRedirect("adminSuccess.jsp");
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
