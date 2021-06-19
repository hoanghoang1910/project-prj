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

    public Account login(String account, String password) {
        
        String query = "SELECT * FROM accounts WHERE account = ? AND password = ?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, account);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account acc = Account.builder()
                        .id(rs.getInt("id"))
                        .account(rs.getString("account"))
                        .password(rs.getString("password"))
                        .displayName(rs.getString("displayName"))
                        .roll(rs.getString("roll"))
                        .build();
                return acc;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args) {      
        AccountDao a = new AccountDao();
        Account acc = a.login("Nguyen Tran Hoang", "19102001");
        System.out.println(acc);
    }
}
