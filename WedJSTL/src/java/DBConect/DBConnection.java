/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConect;

import com.mysql.jdbc.MysqlIO;
import java.sql.JDBCType;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author PhamBaHieu
 */
public class DBConnection {
    public Connection connect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String strCon ="jdbc:mysql://localhost:3306/tinnhanh";
        Connection conn = DriverManager.getConnection(strCon, "root", "");
        return  conn;
    }
}
