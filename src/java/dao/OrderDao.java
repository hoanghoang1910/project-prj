package dao;

import entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;

public class OrderDao {

    public int add(Order order) throws SQLException {

        String query = "Insert into orders (name,mobile,address,totalPrice,note,status,orders.order_date) values (?, ?, ?, ?, ?, ?,GETDATE())";
        int check = 0;
        ResultSet rs = null;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setObject(1, order.getName());
            ps.setObject(2, order.getMobile());
            ps.setObject(3, order.getAddress());
            ps.setObject(4, order.getTotalPrice());
            ps.setObject(5, order.getNote());
            ps.setObject(6, order.getStatus());

            check = ps.executeUpdate();
            if (check > 0) {
                rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            rs.close();
        }
        return 0;
    }

    public List<Order> getOrder() throws SQLException {
        List<Order> list = new ArrayList<>();
        String query = "SELECT * FROM orders";
        ResultSet rs = null;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            rs = ps.executeQuery();
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
        }finally{
            rs.close();
        }
        return null;
    }

    public Order getOrderbyID(int id) throws SQLException {
        String query = "SELECT * FROM orders where id = ?";
        ResultSet rs = null;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return Order.builder().
                        id(rs.getInt(1))
                        .name(rs.getString(2))
                        .mobile(rs.getString(3))
                        .address(rs.getString(4))
                        .totalPrice(rs.getDouble(5))
                        .note(rs.getString(6))
                        .status(rs.getInt(7))
                        .build();
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            rs.close();
        }
        return null;
    }

    public void updateOrder(Order a ,int id) {
        String query = "UPDATE orders SET name=?,mobile=?,address=?,"
                + "totalPrice=?,note=?,status=? where id = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, a.getName());
            ps.setString(2, a.getMobile());
            ps.setString(3, a.getAddress());
            ps.setDouble(4, a.getTotalPrice());
            ps.setString(5, a.getNote());
            ps.setInt(6, a.getStatus());
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) throws SQLException {
        OrderDao a = new OrderDao();
        Order b = a.getOrderbyID(10);
        a.updateOrder(b,10);
    }
}
