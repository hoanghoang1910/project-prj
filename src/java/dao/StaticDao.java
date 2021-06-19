/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;

/**
 *
 * @author Acer
 */
public class StaticDao {

    public int[] getTop5ProductID() {
        String query = "select top 5 orders_detail.product_id \n"
                + "from orders_detail group by orders_detail.product_id\n"
                + "order by(count(orders_detail.quantity)) desc";
        int[] id = new int[5];
        int count = 0;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id[count] = rs.getInt(1);
                count++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return id;
    }

    public double getIncomeToday() {
        String query = "select sum(orders.totalPrice) from orders\n"
                + " where day(orders.order_date) = day(GETDATE())";
        double income = 0;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                income = rs.getDouble(1);
            }
            return income;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return income;
    }

    public double getIncomeThisMonth() {
        String query = " select sum(orders.totalPrice) from orders\n"
                + " where month(orders.order_date) = month(GETDATE())";
        double income = 0;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                income = rs.getDouble(1);
            }
            return income;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return income;
    }

    public List<Order> getHighOrder() {
        List<Order> list = new ArrayList<>();
        String query = "select * from orders where orders.order_date = (select top 1 orders.order_date\n"
                + "from orders group by orders.order_date\n"
                + "order by count(*) desc)";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order a = Order.builder().
                        id(rs.getInt(1))
                        .name(rs.getString(2))
                        .mobile(rs.getString(3))
                        .address(rs.getString(4))
                        .totalPrice(rs.getDouble(5))
                        .note(rs.getString(6))
                        .status(rs.getInt(7))
                        .build();
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public Date getDateOrder() {
        String query = "select * from orders where orders.order_date = (select top 1 orders.order_date\n"
                + "from orders group by orders.order_date\n"
                + "order by count(*) desc)";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Date a = rs.getDate("order_date");
                return a;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<Order> getTop5Customer() {
        List<Order> list = new ArrayList<>();
        String query = "select top 5 *\n"
                + "from orders order by orders.totalPrice desc";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order a = Order.builder().
                        id(rs.getInt(1))
                        .name(rs.getString(2))
                        .mobile(rs.getString(3))
                        .address(rs.getString(4))
                        .totalPrice(rs.getDouble(5))
                        .note(rs.getString(6))
                        .status(rs.getInt(7))
                        .build();
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public int getOrderToday() {
        String query = "select count(*) from orders\n"
                + " where day(orders.order_date) = day(GETDATE()) and month(orders.order_date) = month(GETDATE())";
        int order = 0;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order = rs.getInt(1);
            }
            return order;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return order;
    }

    public List<Order> getTodayOrder() {
        List<Order> list = new ArrayList<>();
        String query = "select * from orders\n"
                + " where day(orders.order_date) = day(GETDATE()) and month(orders.order_date) = month(GETDATE())";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order a = Order.builder().
                        id(rs.getInt(1))
                        .name(rs.getString(2))
                        .mobile(rs.getString(3))
                        .address(rs.getString(4))
                        .totalPrice(rs.getDouble(5))
                        .note(rs.getString(6))
                        .status(rs.getInt(7))
                        .build();
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        StaticDao a = new StaticDao();
//        int[] id = a.getTop5ProductID();
//        for (int i : id) {
//            System.out.println(i);
//        }
//        Double income = a.getIncomeThisMonth();
//        System.out.println(income);
        List<Order> list = a.getTodayOrder();
        for (Order order : list) {
            System.out.println(order);
        }
//        Date date = a.getDateOrder();
//        System.out.println(date);
    }
}
