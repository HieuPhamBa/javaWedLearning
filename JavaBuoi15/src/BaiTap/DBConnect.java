/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTap;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PhamBaHieu
 */
public class DBConnect {
    
    public Connection connect() throws Exception{
            Class.forName("com.mysql.jdbc.Driver");
            String strCon = "jdbc:mysql://localhost:3306/qly_sinhvien";
            Connection cnn = DriverManager.getConnection(strCon, "root", "");
            return cnn;
    }
    
}
