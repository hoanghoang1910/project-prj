/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDao;
import entity.Order;
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
public class AdminUpdateOrder extends HttpServlet {

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
            int id = Integer.parseInt(request.getParameter("id"));
            OrderDao a = new OrderDao();
            Order oder = a.getOrderbyID(id);
            request.setAttribute("order", oder);
            request.getRequestDispatcher("adminUpdateOrder.jsp").forward(request, response);
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
         response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("OrderId"));
        String address = request.getParameter("Address");
        String mobile = request.getParameter("Mobile");
        String name = request.getParameter("CustomerName");
        String note = request.getParameter("Note");
        Double price = Double.parseDouble(request.getParameter("TotalBill"));
        int status = Integer.parseInt(request.getParameter("Status"));
        Order a = Order.builder().
                id(id)
                .address(address)
                .mobile(mobile)
                .name(name)
                .note(note)
                .totalPrice(price)
                .status(status)
                .build();
//        PrintWriter out = response.getWriter();
//        out.print(a);
          OrderDao b = new OrderDao();
          b.updateOrder(a,a.getId());
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
