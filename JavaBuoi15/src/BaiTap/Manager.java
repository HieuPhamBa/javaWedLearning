/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTap;
import com.sun.javafx.scene.layout.region.Margins;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.css.ParsedValue;

public class Manager {
    private ResultSet rs;
    private DBConnect dbc = null;
    private Connection cnt = null;
    private PreparedStatement pstm = null;
    private int id;
    
    public Manager(){
        dbc = new DBConnect();
        try {
            cnt = dbc.connect();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }   
    }
    
    public Student login(){
        String query ="";
        Student std = new Student();
        String email, pass;
        System.out.print("Nhap email>");
        email = (new Scanner(System.in)).nextLine();
        System.out.print("Nhap pass>");
        pass = (new Scanner(System.in)).nextLine();
        query = "SELECT * FROM sinhVien WHERE sinhVien.email = ? AND sinhVien.pass = ?";
        try{
            pstm = cnt.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            if( rs.next()){
                std = new Student(rs.getString("id"), rs.getString("NameSv"), email, pass);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return std;
    }
    
    public int addAns(Quiz quiz, int id, String as) throws SQLException{
  
        String query = "INSERT INTO sv_quiz value (?,?,?)";  
        
        try {
            PreparedStatement pstmSV_Quiz = cnt.prepareStatement(query);
            
            pstmSV_Quiz.setInt(1, id);
            pstmSV_Quiz.setInt(2, quiz.getId());
            pstmSV_Quiz.setString(3, as);   
            return  pstmSV_Quiz.executeUpdate();
        } catch (SQLException ex) {  
        }
        return 0;
    }
    
   public boolean isComplete(Student std) throws SQLException{
       String query = "SELECT * FROM sinhVien WHERE sinhVien.id = ?";
       pstm = cnt.prepareStatement(query);
       pstm.setInt(1, Integer.parseInt(std.getId()));
       ResultSet rs = pstm.executeQuery();
       return rs.next();
   }
   
   public void resetQuiz(Student std) throws SQLException{
       String query = "DELETE * FROM sinnhVien WHERE sinhVien.id = ?";
       pstm = cnt.prepareStatement(query);
       pstm.setInt(1, Integer.parseInt(std.getId()));
       pstm.executeUpdate();
   }
    
   public int addAns(Student std, Quiz quiz, String ans) throws SQLException{
       String query = "INSERT INTO sv_quis VALUE (?,?,?)";
       pstm = cnt.prepareStatement(query);
       pstm.setInt(1,Integer.parseInt(std.getId()));
       pstm.setInt(2, quiz.getId());
       pstm.setString(3, ans);
       return pstm.executeUpdate();
   }
   
    
    public void printResult(Student s) throws SQLException, ClassNotFoundException {

        String query = "select sq.correct as student_answer, q.* from student_questions as sq "
                + "join questions as q on q.`id` = sq.`question_id` "
                + "where sq.`student_id` = ?";
        PreparedStatement pstmt = this.cnt.prepareStatement(query);
        pstmt.setInt(1, Integer.parseInt(s.getId()));
        ResultSet rs = pstmt.executeQuery();
        int questionCount = 1;
        
        QuizzManager qm = new QuizzManager();
        List<Quiz> questions = qm.insertQuizz();
//        
//        int total = 0;
//        while (rs.next()) {
//            total++;
//        }
//        rs.beforeFirst();

        while (rs.next()) {
            // so sanh ket qua
            String result = rs.getString("correct").toLowerCase()
                    .equals(rs.getString("student_answer").toLowerCase()) 
                    ? "True" : "False";
            System.out.printf("Question %d/%d - %s\n", questionCount++, questions.size() ,result);
            System.out.println(rs.getString("content"));
            
            if (rs.getString("correct").equals("a"))
                System.out.println("[A]. " + rs.getString("answer_a"));
            else 
                System.out.println("A. " + rs.getString("answer_a"));
            
            if (rs.getString("correct").equals("b"))
                System.out.println("[B]. " + rs.getString("answer_b"));
            else 
                System.out.println("B. " + rs.getString("answer_b"));
            
            if (rs.getString("correct").equals("c"))
                System.out.println("[C]. " + rs.getString("answer_c"));
            else 
                System.out.println("C. " + rs.getString("answer_c"));
            
            if (rs.getString("correct").equals("d"))
                System.out.println("[D]. " + rs.getString("answer_d"));
            else 
                System.out.println("D. " + rs.getString("answer_d"));
            
            
        }
    
}
