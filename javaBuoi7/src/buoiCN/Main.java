/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoiCN;
import java.util.Scanner;
public class Main 
{
    
    public static void menu()
    {
        System.out.println("Moi chon:");
        System.out.println(" 1. Add.");
        System.out.println(" 2. Search.");
        System.out.println(" 3. List.");
        System.out.println(" 4 exit.");
        System.out.println("Moi ban chon: ");
    }
    
    public static void main(String[] args) {
        Store myStore = new Store();
        Scanner myScan = new Scanner(System.in);
        while(true){
            menu();
            int op = myScan.nextInt();
            switch(op){
                case 1:
                    myStore.add();
                    break;
                case 2: 
                    myStore.search();
                    break;
                case 3:
                    myStore.list();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    main(args);
                    break;
            }
        }
    }
}
