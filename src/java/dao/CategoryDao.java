/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;

public class CategoryDao implements IMethod<Category> {
    
    @Override
    public List<Category> getAll() {
        
        String query = "SELECT * FROM categories";
        List<Category> ls = new ArrayList<>();
        
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = Category.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .status(rs.getInt(3))
                        .build();
                ls.add(category);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public Category getOne(int id) {
        
        String query = "SELECT * FROM categories WHERE id = ?";
        
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category p = Category.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .status(rs.getInt(3))
                        .build();
                return p;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public boolean add(Category obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean update(int id, Category obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
