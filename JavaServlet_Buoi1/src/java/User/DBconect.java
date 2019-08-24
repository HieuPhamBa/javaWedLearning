/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;
import java.sql.*;
/**
 *
 * @author PhamBaHieu
 */
public class DBconect {
    public Connection connect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String strCon = "jdbc:mysql://localhost:3306/qly_sinhvien";
        Connection cnn = DriverManager.getConnection(strCon, "root", "");
        return cnn;
    }
}
