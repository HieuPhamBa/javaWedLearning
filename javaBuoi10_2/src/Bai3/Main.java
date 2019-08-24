/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;
import java.util.Scanner;
/**
 *
 * @author PhamBaHieu
 */
public class Main {
    public static void menu(){
        System.out.println("----Menu---");
        System.out.println(" 1. load task");
        System.out.println(" 2. add");
        System.out.println(" 3. show all");
        System.out.print("Moi chon: ");
    }
    public static void main(String[] args) {
        String filePath = "C:\\Users\\PhamBaHieu\\Desktop\\text.txt";
        TaskManager myMan = new TaskManager(filePath);
       
        while(true){
            menu();
            int option = new Scanner(System.in).nextInt();
            switch(option){
                case 1:
                    myMan.loadTask();
                    break;
                case 2:
                    myMan.add(filePath);
                    break;
                case 3:
                    myMan.showAll(filePath);
                    break;
            }
        }
    }
}
