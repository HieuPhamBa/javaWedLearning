/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.DB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PhamBaHieu
 */
public class DBConnect {

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/qlthuvien";
        String user = "root";
        String pass = "";
        return DriverManager.getConnection(url, user, pass);
    }
}