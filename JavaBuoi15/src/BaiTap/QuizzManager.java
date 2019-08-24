/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhamBaHieu
 */
public class QuizzManager extends Quiz {
    private List<Quiz> lstQuiz = new ArrayList<Quiz>();
    private Quiz quiz = null;
    private Connection conn;
    public QuizzManager(){
      
        try {
            conn = (new DBConnect()).connect();
        } catch (Exception ex) {
           
        }
    }
    
    public List<Quiz> insertQuizz() throws SQLException{
        String query = "SELECT * FROM dethi";
        PreparedStatement pstm = conn.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
           // quiz.setId(rs.getInt("id"));
            quiz.setCnt(rs.getString("question"));
            quiz.setQuiz_a(rs.getString("as_a"));
            quiz.setQuiz_b(rs.getString("as_b"));
            quiz.setQuiz_c(rs.getString("as_c"));
            quiz.setQuiz_d(rs.getString("as_d"));
            quiz.setCorrectAn(rs.getString("cr_as"));
        }
        return lstQuiz;
    }

}
