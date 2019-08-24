/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTap;

public class Quiz {
    private  int id;
    private String cnt, quiz_a, quiz_b, quiz_c, quiz_d, correctAn;

    public Quiz() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public String getQuiz_a() {
        return quiz_a;
    }

    public void setQuiz_a(String quiz_a) {
        this.quiz_a = quiz_a;
    }

    public String getQuiz_b() {
        return quiz_b;
    }

    public void setQuiz_b(String quiz_b) {
        this.quiz_b = quiz_b;
    }

    public String getQuiz_c() {
        return quiz_c;
    }

    public void setQuiz_c(String quiz_c) {
        this.quiz_c = quiz_c;
    }

    public String getQuiz_d() {
        return quiz_d;
    }

    public void setQuiz_d(String quiz_d) {
        this.quiz_d = quiz_d;
    }

    public String getCorrectAn() {
        return correctAn;
    }

    public void setCorrectAn(String correctAn) {
        this.correctAn = correctAn;
    }

 
    
    public boolean checkResult(String ans){
        return this.correctAn.equals(ans);
    }
    
    @Override
    public String toString(){
        return this.getCnt()+"\n"+
               this.getQuiz_a()+"\n"+
               this.getQuiz_b()+"\n"+
               this.getQuiz_c()+"\n"+
               this.getQuiz_d()+"\n"+
               "Input your answer>";
    }
    
    
}
