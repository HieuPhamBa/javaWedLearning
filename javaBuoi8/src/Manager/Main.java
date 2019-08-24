/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScan  = new Scanner(System.in);
        Manager myMan = null;
        System.out.println("Moi chon\n S: student \tE: Employee");
        String op = myScan.nextLine();
        switch(op)
        {
            case "s": case "S":
                myMan = new ManagerStudent();
                break;
            case "e": case "E":
                myMan = new ManagerStudent();
                break;
            default:
                main(args);
        }
        
        Menu myMenu = new Menu(myMan);
        myMenu.menu();
    }
}
