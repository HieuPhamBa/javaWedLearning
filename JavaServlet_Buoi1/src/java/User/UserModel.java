/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhamBaHieu
 */
public class UserModel {
    private Connection cnn = null;
    private PreparedStatement psmt = null;
    private DBconect dbcn = null;
    
    public UserModel() throws ClassNotFoundException, SQLException{
        dbcn = new DBconect();
        cnn = dbcn.connect();
    }
    
    public User signIn(String email, String pass) throws SQLException{
        User us = null;
       String strSelect = "SELECT * FROM sinhvien WHERE email = ? AND pass = ? ";
       psmt = cnn.prepareStatement(strSelect);
       psmt.setString(1, email);
       psmt.setString(2, pass);
       ResultSet rs = psmt.executeQuery();
 
       if( rs.next())
       {
           us = new User();
           us.setEmail(rs.getString("email"));
           us.setName(rs.getString("NameSv"));
           us.setId(rs.getInt("id"));
           us.setPass(rs.getString("pass"));
       }
       return us;
    }
    
    private int nextId() {
        String strGetMaxId = "SELECT MAX(id) FROM sinhvien";
        try {
            psmt = cnn.prepareStatement(strGetMaxId);    
            ResultSet rs;
            rs = psmt.executeQuery();
            if(rs.next())
                return rs.getInt("MAX(id)")+1;
        } catch (SQLException ex) {
           
        }
        return 100;
    }
    
    public boolean signUp(User us) throws SQLException
    {
       
        
        int id  = nextId();
         String strInsert = "INSERT INTO sinhvien(id,NameSv,email,pass) VALUES("+id+",'"+us.getName()
                 +"','"+us.getEmail()+"','"+us.getPass()+"')";
         psmt = cnn.prepareStatement(strInsert);
        return psmt.executeUpdate()>0;
    }    
}
