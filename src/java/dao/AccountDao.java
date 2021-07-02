/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.SQLServerConnection;

public class AccountDao {

    public Account login(String account, String password) throws SQLException {
        
        String query = "SELECT * FROM accounts WHERE account = ? AND password = ?";
        ResultSet rs = null;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, account);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                
                return Account.builder()
                        .id(rs.getInt("id"))
                        .account(rs.getString("account"))
                        .password(rs.getString("password"))
                        .displayName(rs.getString("displayName"))
                        .roll(rs.getString("roll"))
                        .build();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            rs.close();    
        }
        return null;
        
    }
    
    public static void main(String[] args) throws SQLException {      
        AccountDao a = new AccountDao();
        Account acc = a.login("Nguyen Tran Hoang", "19102001");
        System.out.println(acc);
    }
}
