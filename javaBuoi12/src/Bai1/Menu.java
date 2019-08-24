/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Menu {
    private CustomerManager cusManager = new  CustomerManager();
    private void menu(){
        System.out.println("---Menu---");
        System.out.println("1. Add new.");
        System.out.println("2. Search.");
        System.out.println("3. Xem ");
        System.out.println("4. Exit ");
    }
    
    public void manager(){
        menu();
        int choice = (new Scanner(System.in)).nextInt();
        switch(choice)
        {
            case 1:
                cusManager.add();
                break;
            case 2:
                System.out.println(cusManager.Search());
                break;
            case 3:
                cusManager.output();
                break;
            default:
                System.out.println("Ban hãy chọn lại!!!!");
                manager();
        }
    }
}
