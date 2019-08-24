/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author PhamBaHieu
 */
public class DBConection {
   public Connection connect() throws Exception{
            Class.forName("com.mysql.jdbc.Driver");
            String strCon = "jdbc:mysql://localhost:3306/qly_sinhvien";
            Connection cnn = DriverManager.getConnection(strCon, "root", "");
            return cnn;
    }
}
