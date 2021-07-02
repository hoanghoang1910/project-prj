/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;


public class ImageDao {

    public List<Image> getAllByProductId(int id) throws SQLException {
        
        String query = "SELECT * FROM images WHERE product_id = ?";
        List<Image> ls = new ArrayList<>();
        ResultSet rs = null;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                Image image = Image.builder()
                        .id(rs.getInt(1))
                        .productId(rs.getInt(2))
                        .imageName(rs.getString(3))
                        .build();
                ls.add(image);
            }
            rs.close();
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            rs.close();
        }
        return null;
    }    
}
