/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.Model;

import com.java.Bean.User;
import com.java.DB.DBConnect;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PhamBaHieu
 */
public class UserModel {
    private DBConnect dbcon = null;
    public UserModel(){
        
    }
    public String auth(String email, String pass){
        dbcon = new DBConnect();
        try {
            Connection cnn = dbcon.connect();
            String strSel = "Select * from users where email = ? and pass = ?";
            PreparedStatement pstm = cnn.prepareStatement(strSel);
            pstm.setString(1, email);
            pstm.setString(2, pass);
            ResultSet rs = pstm.executeQuery();
            if(rs.next())
                return  rs.getString("name");
            else{
                  return null;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
