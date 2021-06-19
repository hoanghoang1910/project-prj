/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDao;
import dao.BrandDao;
import dao.CategoryDao;
import dao.ProductDao;
import entity.Account;
import entity.Brand;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CheckoutServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
            List<Brand> lsBrand = new BrandDao().getAll();
            List<Category> lsCategory = new CategoryDao().getAll();
            List<Product> lsProduct = new ProductDao().getAll();
            request.setAttribute("lsBrand", lsBrand);
            request.setAttribute("lsCategory", lsCategory);
            request.setAttribute("lsProduct", lsProduct);
            request.setAttribute("user", "ADMIN");
            request.getRequestDispatcher("admin2.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();
        String account = request.getParameter("username");
        String password = request.getParameter("password");
        AccountDao a = new AccountDao();
        Account user = a.login(account, password);
        if (user != null) {
            if ("admin".equals(user.getRoll())) {
                List<Brand> lsBrand = new BrandDao().getAll();
                List<Category> lsCategory = new CategoryDao().getAll();
                List<Product> lsProduct = new ProductDao().getAll();
                request.setAttribute("lsBrand", lsBrand);
                request.setAttribute("lsCategory", lsCategory);
                request.setAttribute("lsProduct", lsProduct);
                request.setAttribute("user", user.getDisplayName());
                request.getRequestDispatcher("admin2.jsp").forward(request, response);
            } else {
                RequestDispatcher rDispatcher = request.getRequestDispatcher("/products");
                rDispatcher.forward(request, response);
            }
        } else {
            out.print("Login failed");
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
