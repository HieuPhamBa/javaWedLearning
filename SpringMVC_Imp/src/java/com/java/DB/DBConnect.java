/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.DB;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author PhamBaHieu
 */
public class DBConnect {
    public Connection connect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String str ="jdbc:mysql://localhost:3306/usermanager";
        Connection cnn = null;
        cnn = DriverManager.getConnection(str, "root", "");
        return cnn;
    }
}
