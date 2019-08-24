/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template i1n the editor.
 */
package DateMothn;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class Main {
    public static void menu(){
        MyDate myD = new MyDate();
        Scanner readKey = new Scanner(System.in);
        System.out.println("/***********MENU***************/");
        System.out.println(" *1,Nhap ngay, thang, nam.");
        System.out.println(" *2,In ngay, thang, nam.");
        System.out.println(" *3,In ten nam can chi.");
        System.out.println(" *4,Cong ngay, thang, nam.");
        System.out.println(" *5,Tru ngay, thang, nam.");
        System.out.println(" *6,In xem ngay do thu may.");
        System.out.println(" *7,Thoat.");
        System.out.println("/******************************/");
        System.out.print("-Moi chon: ");
        int option = readKey.nextInt();
        switch(option)
        {
            case 1:
                myD.inputDMY();
                break;
            case 2:
                myD.outputDMY();
                break;
            case 3:
                myD.takeDate();
                break;
            case 4:
                int day = readKey.nextInt();
                myD.addDay(day);
                break;
            case 5:
                day = readKey.nextInt();
                myD.oddDay(day);
                break;
            case 6:
                myD.getNamYear();
                break;
            case 7:
                System.exit(0);
            
        }
        menu();
    }
    public static void main(String[] args) {
       menu();
    }
   
   
}
