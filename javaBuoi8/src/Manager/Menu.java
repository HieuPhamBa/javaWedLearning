/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;
import java.util.Scanner;
public class Menu {
    protected Manager myMan = null;
    protected Scanner myScan = new Scanner(System.in);
    public Menu() {
    }
    
    public Menu(Manager myMan) {
        this.myMan = myMan;
    }
 
    public void display(){
         System.out.println("----Menu----");
        System.out.println(" 1. add");
        System.out.println(" 2. show");
        System.out.println(" 3. search");
        System.out.println(" 4. Exit");
        System.out.print("Moi nhap>");
        int op = myScan.nextInt();
        switch(op)
        {
            case 1:
                this.myMan.add();
                break;
            case 2:
                this.myMan.show();
                break;
            case 3:
                myScan.nextLine();
                System.out.print("Moi nhap 1 cai ten>");
                String strName = myScan.nextLine();
                this.myMan.search(strName);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                display();
                break;
        }
        return ;
    }
    public void menu(){
       while(true)
           display();
    }
}
