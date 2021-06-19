/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDao;
import dao.StaticDao;
import entity.Order;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
@WebServlet(name = "AdminStatisticServlet", urlPatterns = {"/AdminStatisticServlet"})
public class AdminStatisticServlet extends HttpServlet {

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
            StaticDao a = new StaticDao();
            ProductDao b = new ProductDao();
            int id[] = a.getTop5ProductID();
            List<Product> lsProduct = new ArrayList<>();
            for (int i : id) {
                Product p = b.getOne(i);
                lsProduct.add(p);
            }
          
//            for (Product l : ls) {
//                out.println(l);
//            }
            double incomeToday = a.getIncomeToday();
            double incomeThisMonth = a.getIncomeThisMonth();
            List<Order> listToday = a.getTodayOrder();
            List<Order> list = a.getHighOrder();
            Date highOrderDate = a.getDateOrder();
            List<Order> cus = a.getTop5Customer();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            String currentDate = dtf.format(now);
            int numberOrderToday = a.getOrderToday();
            out.print(currentDate);
            request.setAttribute("numberOrder", numberOrderToday);
            request.setAttribute("productLS", lsProduct);
            request.setAttribute("incomeToday", incomeToday);
            request.setAttribute("incomeThisMonth", incomeThisMonth);
            request.setAttribute("order", list);
            request.setAttribute("highOrderDate", highOrderDate);
            request.setAttribute("currentDate", currentDate);
            request.setAttribute("customer", cus);
            request.setAttribute("todayOrder", listToday);
            request.getRequestDispatcher("adminStatic.jsp").forward(request, response);
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
        processRequest(request, response);
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
