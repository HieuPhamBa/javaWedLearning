/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PhamBaHieu
 */
public class SinhVienModel {
    private SinhVien sv = null;
    private Connection cnn = null;
    private PreparedStatement pstm = null;
    private DBConection dbCon = null;
    
    public SinhVienModel() {
       
    }
    
    public ArrayList<SinhVien> getSinhVien() throws SQLException, ClassNotFoundException{
        ArrayList<SinhVien> lst = new  ArrayList<>();
        dbCon = new DBConection();
        try {
            cnn = dbCon.connect();
        } catch (Exception ex) {
            Logger.getLogger(SinhVienModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM sinhvien;";
        pstm = cnn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            sv = new SinhVien();
            sv.setEmail(rs.getString("email"));
            sv.setId(rs.getInt("id"));
            sv.setName(rs.getString("NameSv"));
            lst.add(sv);
        }
        return lst;
    }
    
    public ArrayList<SinhVien> getSinhVienAfterName(String name) throws SQLException, ClassNotFoundException{
        ArrayList<SinhVien> lst = new  ArrayList<>();
        dbCon = new DBConection();
        try {
            cnn = dbCon.connect();
        } catch (Exception ex) {
            Logger.getLogger(SinhVienModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM sinhvien WHERE NameSv = ?;";
        pstm = cnn.prepareStatement(sql);
        pstm.setString(1, name);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            sv = new SinhVien();
            sv.setEmail(rs.getString("email"));
            sv.setId(rs.getInt("id"));
            sv.setName(rs.getString("NameSv"));
            lst.add(sv);
        }
        return lst;
    }
}
