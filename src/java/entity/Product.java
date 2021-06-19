/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.SQLServerConnection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@Setter
@Getter
@ToString
public class Product {

    private int id;
    private int brandId;
    private int categoryId;
    private String name;
    private double price;
    private int quantity;
    private String imgName;
    private String description;
    private String note;
    private int status; 

 public String getOne() {
        int id = this.categoryId;
        String query = "SELECT * FROM categories WHERE id = ?";
        
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                return name;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
       
}
