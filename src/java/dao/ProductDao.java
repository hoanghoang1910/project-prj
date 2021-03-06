package dao;

import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;

public class ProductDao implements IMethod<Product> {

    @Override
    public List<Product> getAll() {

        String query = "SELECT * FROM products";
        List<Product> ls = new ArrayList<>();

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = Product.builder()
                        .id(rs.getInt(1))
                        .brandId(rs.getInt(2))
                        .categoryId(rs.getInt(3))
                        .name(rs.getString(4))
                        .price(rs.getDouble(5))
                        .quantity(rs.getInt(6))
                        .imgName(rs.getString(7))
                        .description(rs.getString(8))
                        .note(rs.getString(9))
                        .status(rs.getInt(10))
                        .build();
                ls.add(product);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Product getOne(int id) {

        String query = "SELECT * FROM products WHERE id = ?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = Product.builder()
                        .id(rs.getInt(1))
                        .brandId(rs.getInt(2))
                        .categoryId(rs.getInt(3))
                        .name(rs.getString(4))
                        .price(rs.getDouble(5))
                        .quantity(rs.getInt(6))
                        .imgName(rs.getString(7))
                        .description(rs.getString(8))
                        .note(rs.getString(9))
                        .status(rs.getInt(10))
                        .build();
                return product;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(Product obj) {

        String query = "INSERT INTO products VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int check = 0;

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, obj.getBrandId());
            ps.setObject(2, obj.getCategoryId());
            ps.setObject(3, obj.getName());
            ps.setObject(4, obj.getPrice());
            ps.setObject(5, obj.getQuantity());
            ps.setObject(6, obj.getImgName());
            ps.setObject(7, obj.getDescription());
            ps.setObject(8, obj.getNote());
            ps.setObject(9, obj.getStatus());

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, Product obj) {

        String query = "UPDATE products SET "
                + "brand_id = ?, "
                + "category_id = ?, "
                + "name = ?, "
                + "price = ?, "
                + "quantity = ?, "
                + "img_name = ?, "
                + "description = ?, "
                + "note = ?, "
                + "status = ? "
                + "WHERE id = ?";
        int check = 0;

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, obj.getBrandId());
            ps.setObject(2, obj.getCategoryId());
            ps.setObject(3, obj.getName());
            ps.setObject(4, obj.getPrice());
            ps.setObject(5, obj.getQuantity());
            ps.setObject(6, obj.getImgName());
            ps.setObject(7, obj.getDescription());
            ps.setObject(8, obj.getNote());
            ps.setObject(9, obj.getStatus());
            ps.setObject(10, id);

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean remove(int id) {

        String query = "DELETE FROM products WHERE id = ?";
        int check = 0;

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<Product> searchByName(String text) {

        String query = "SELECT * FROM products WHERE name LIKE ?";
        List<Product> ls = new ArrayList<>();

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, "%" + text + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = Product.builder()
                        .id(rs.getInt(1))
                        .brandId(rs.getInt(2))
                        .categoryId(rs.getInt(3))
                        .name(rs.getString(4))
                        .price(rs.getDouble(5))
                        .quantity(rs.getInt(6))
                        .imgName(rs.getString(7))
                        .description(rs.getString(8))
                        .note(rs.getString(9))
                        .status(rs.getInt(10))
                        .build();
                ls.add(product);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<Product> filterByBrand(int id) {

        String query = "SELECT * FROM products WHERE brand_id = ?";
        List<Product> ls = new ArrayList<>();

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = Product.builder()
                        .id(rs.getInt(1))
                        .brandId(rs.getInt(2))
                        .categoryId(rs.getInt(3))
                        .name(rs.getString(4))
                        .price(rs.getDouble(5))
                        .quantity(rs.getInt(6))
                        .imgName(rs.getString(7))
                        .description(rs.getString(8))
                        .note(rs.getString(9))
                        .status(rs.getInt(10))
                        .build();
                ls.add(product);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<Product> filterByCategory(int id) {

        String query = "SELECT * FROM products WHERE category_id = ?";
        List<Product> ls = new ArrayList<>();

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = Product.builder()
                        .id(rs.getInt(1))
                        .brandId(rs.getInt(2))
                        .categoryId(rs.getInt(3))
                        .name(rs.getString(4))
                        .price(rs.getDouble(5))
                        .quantity(rs.getInt(6))
                        .imgName(rs.getString(7))
                        .description(rs.getString(8))
                        .note(rs.getString(9))
                        .status(rs.getInt(10))
                        .build();
                ls.add(product);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public void updateProduct(int id, Product obj) {

        String query = "UPDATE products SET "
                + "brand_id = ?, "
                + "category_id = ?, "
                + "name = ?, "
                + "price = ?, "
                + "quantity = ?, "
                + "img_name = ?, "
                + "description = ?, "
                + "note = ?, "
                + "status = ? "
                + "WHERE id = ?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, obj.getBrandId());
            ps.setObject(2, obj.getCategoryId());
            ps.setObject(3, obj.getName());
            ps.setObject(4, obj.getPrice());
            ps.setObject(5, obj.getQuantity());
            ps.setObject(6, obj.getImgName());
            ps.setObject(7, obj.getDescription());
            ps.setObject(8, obj.getNote());
            ps.setObject(9, obj.getStatus());
            ps.setObject(10, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void removeProducts(int id) {

        String query = "DELETE FROM products WHERE id = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public List<Product> getAllPagging(int index) {

        String query = "select * from products order by id \n"
                + "OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY ";
        List<Product> ls = new ArrayList<>();

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, (index - 1) * 8);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = Product.builder()
                        .id(rs.getInt(1))
                        .brandId(rs.getInt(2))
                        .categoryId(rs.getInt(3))
                        .name(rs.getString(4))
                        .price(rs.getDouble(5))
                        .quantity(rs.getInt(6))
                        .imgName(rs.getString(7))
                        .description(rs.getString(8))
                        .note(rs.getString(9))
                        .status(rs.getInt(10))
                        .build();
                ls.add(product);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public int count() {
        String query = "select count(*) from products";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return 0;
    }

    public static void main(String[] args) {
//        List<Product> ls = new ArrayList<>();
       
        ProductDao a = new ProductDao();
        int count = a.count();
        System.out.println(count);
//        ls = a.getAllPagging(1);
//        for (Product l : ls) {
//            System.out.println(l);
//        }
//        
        
    }
}
