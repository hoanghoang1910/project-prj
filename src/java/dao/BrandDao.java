/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.SQLServerConnection;


public class BrandDao implements IMethod<Brand> {

    @Override
    public List<Brand> getAll() {

        String query = "SELECT * FROM brands";
        List<Brand> ls = new ArrayList<>();
        ResultSet rs = null;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {

            rs = ps.executeQuery();
            while (rs.next()) {
                Brand brand = Brand.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .status(rs.getInt(3))
                        .build();
                ls.add(brand);
            }
            
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try 
            {
            rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(BrandDao.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        return null;
    }

    @Override
    public Brand getOne(int id) {

        String query = "SELECT * FROM brands WHERE id = ?";
        ResultSet rs = null;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return Brand.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .status(rs.getInt(3))
                        .build();
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(BrandDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public boolean add(Brand obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(int id, Brand obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        BrandDao a = new BrandDao();
        Brand b = a.getOne(1);
        System.out.println(b);
    }
}
