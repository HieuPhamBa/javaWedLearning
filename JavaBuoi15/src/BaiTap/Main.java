/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTap;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhamBaHieu
 */
public class Main {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Scanner input = new Scanner(System.in);
            System.out.println("   QUIZ ONLINE   ");
            System.out.println("------------------");
           

            Manager sm = new Manager();
            Student s = sm.login();

            if (s != null) {
                System.out.println("LOGIN SUCCESS! PRESS ANY KEY TO START QUIZ");
                input.nextLine();
                boolean completed = sm.isComplete(s);
                if (completed) {
                    System.out.println("YOU HAVE COMPLETED THE TEST.");
                    System.out.print("DO YOU WANT TO DO IT AGAIN (Y/N): ");
                    String cont = input.nextLine();
                    if (cont.toLowerCase().equals("y")) {
                        sm.resetQuiz(s);
                        startQuiz(input, sm, s);    
                    }
                } else {
                    startQuiz(input, sm, s);
                }
            } else {
                System.out.println("LOGIN FAIL!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void startQuiz(Scanner input, Manager sm, Student s) throws ClassNotFoundException, SQLException {
        System.out.println("---------------");
        QuizzManager qm = new QuizzManager();
        List<Quiz> questions = qm.insertQuizz();
        int countCorr = 0;
        int index = 1;
        for (Quiz q : questions) {
            System.out.printf("Question %d/%d \n", index++, questions.size());
            System.out.println(q);
            System.out.print("Your answer > ");
            String answer = input.nextLine();
            sm.addAns(s, q, answer);
            if (answer.toLowerCase().equals(q.getCorrectAn().toLowerCase())) {
                countCorr++;
            }
        }
        System.out.println("Congratulation!");
        System.out.printf("Your result: %d/%d \n", countCorr, questions.size());
        System.out.print("See Detail (Y/N) > ");

        String cont = input.nextLine();
        if (cont.toLowerCase().equals("y")) {
            sm.printResult(s);
        }
    }

}
