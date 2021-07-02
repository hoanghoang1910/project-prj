/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cart;
import entity.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;


public class OrderDetailDao {

    public boolean add(List<Cart> listCart, int orderId) {

        String query = "INSERT INTO orders_detail(order_id,product_id,name,price,img_name,quantity) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            for (Cart c : listCart) {
                ps.setObject(1, orderId);
                ps.setObject(2, c.getId());
                ps.setObject(3, c.getName());
                ps.setObject(4, c.getPrice());
                ps.setObject(5, c.getImgName());
                ps.setObject(6, c.getQuantity());
                ps.addBatch();
            }
            ps.executeBatch();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return false;
    }

    public List<OrderDetail> getOrderDetail(int id) throws SQLException {
        List<OrderDetail> list = new ArrayList<>();
        String query = "SELECT * FROM orders_detail where order_id = ?";
        ResultSet rs = null;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                OrderDetail a = OrderDetail.builder().
                        orderId(rs.getInt(1))
                        .productId(rs.getInt(2))
                        .productName(rs.getString(3))
                        .productPrice(rs.getDouble(4))
                        .img_name(rs.getString(5))
                        .quantity(rs.getInt(6))
                        .build();
                list.add(a);
            }
            
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            rs.close();
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        OrderDetailDao a = new OrderDetailDao();
        List<OrderDetail> list = a.getOrderDetail(6);
        for (OrderDetail orderDetail : list) {
            System.out.println(orderDetail);
        }
    }
}
