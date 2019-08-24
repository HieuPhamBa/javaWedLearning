/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.Model;

import com.java.Beans.Books;
import com.java.DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhamBaHieu
 */
public class BooksModel {
    private Connection cnn = null;
    private DBConnect dbcon = null;
    
    public BooksModel(){
        dbcon = new DBConnect();
    }
    
    
    public List<Books> loadAll(){
        List<Books> list = new ArrayList<>();
        Books bks = null;
        try {
            cnn = dbcon.getConnection();
            String strSel = "Select * from book";
            PreparedStatement pstm = cnn.prepareStatement(strSel);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                bks = new Books();
                bks.setId(rs.getInt("id"));
                bks.setAuthor(rs.getString("author"));
                bks.setTitle(rs.getString("title"));
                bks.setPrice(rs.getInt("prices"));
                bks.setQuantily(rs.getInt("quantily"));
                list.add(bks);
            }
        } catch (Exception ex) {
           
        }
        return list;
    }
    
    public boolean DeleteBooks(int id){
        try {
            cnn = dbcon.getConnection();
            String strDel = "delete from books where id = ?";
            PreparedStatement pstm = cnn.prepareStatement(strDel);
            pstm.setInt(1, id);
            return pstm.executeUpdate()>0;
        } catch (Exception ex) {
           
        }
        return false;
    }
    
    public boolean InsertBooks(Books bks){
       String strIntsert =  "INSERT INTO Book(title, author, prices, quantily) "+
                            "VALUES( '"+bks.getTitle()+"', '"+bks.getAuthor()+"', "+bks.getPrice()+","+bks.getQuantily()+"),";
        try {
            cnn = dbcon.getConnection();
            PreparedStatement pstm = cnn.prepareStatement(strIntsert);
            return pstm.executeUpdate()>0;
        } catch (Exception ex) {
           
        }
        return false;
    }
    
    public Books selectByID(int id){
            Books  bks = new Books();;
        try {
            cnn = dbcon.getConnection();
            String strSel = "Select * from books where id = ?";
            PreparedStatement pstm = cnn.prepareStatement(strSel);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                bks.setId(rs.getInt("id"));
                bks.setAuthor(rs.getString("author"));
                bks.setTitle(rs.getString("title"));
                bks.setPrices(rs.getInt("prices"));
                bks.setQuantily(rs.getInt("quantily"));
            }
        } catch (Exception ex) {
        }
        return bks;
    }
}
