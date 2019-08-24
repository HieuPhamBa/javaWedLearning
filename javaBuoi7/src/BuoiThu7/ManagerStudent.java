/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuoiThu7;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class ManagerStudent extends Student{
    private ArrayList <Student> arrStudy = new ArrayList<Student>();
    private  int numStudy = 0;

    public ManagerStudent() {
    }

    public ManagerStudent(String name, String email, int age) {
        super(name, email, age);
    }

    public  int getNumStudy() {
        return numStudy;
    }

    public void setNumStudy(int numStudy) {
        this.numStudy = numStudy;
    }
    
    public boolean add()
    {
        Student myStudy = new Student();
        Scanner readKey = new Scanner(System.in);
        System.out.println("----Add----");
        System.out.print("Nhap ten>");
        String name = readKey.nextLine();
        myStudy.setName(name);
        System.out.print("Nhap email>");
        String email = readKey.nextLine();
        myStudy.setEmail(email);
        System.out.print("Nhap tuoi>");
        int age = readKey.nextInt();
        myStudy.setAge(age);
        if(numStudy>arrStudy.size())
            return false;
        numStudy++;
        this.setNumStudy(numStudy);
        arrStudy.add(myStudy);
        return true;
    }
    
    private void showInfo(Student svien){
        System.out.printf("%5s|%15s|%7s|\n","Name","Email","age");
        System.out.printf("+=====+===============+=======+\n");
        System.out.printf("|%5s|%15s|%7d|\n",svien.getName(),svien.getEmail(),svien.getAge());
        System.out.printf("+=====+===============+=======+\n");
    }
    
    public void search(){
        Scanner readKey = new Scanner(System.in);
        System.out.println("---Tim kiem---");
        System.out.print("Nhap 1 ten>");
        String name = readKey.nextLine();
        for(Student var : arrStudy){
            if( name.equals(var.getName())){
                showInfo(var);
                return ; 
            }
        }
        System.out.println("Khong tim thay :(((");
        return ;
        
    }
    
    private void sortAcesding()
    {
        for( int i=0; i<this.getNumStudy()+1; i++)
            for( int j=i+1; j<this.getNumStudy(); j++)
                if(arrStudy.get(i).getAge()>arrStudy.get(j).getAge())
                      Collections.swap(arrStudy, i, j);
    }
    
    private void sortDecrease()
    {
         for( int i=0; i<this.getNumStudy(); i++)
            for( int j=i+1; j<this.getNumStudy(); j++)
                if(arrStudy.get(i).getAge()<arrStudy.get(j).getAge())
                      Collections.swap(arrStudy, i, j);
    }
    public void list(boolean order){
        if(order){
            this.sortAcesding();
        }
        else
            this.sortDecrease();
    }
    
    public void outputArrayList(){
        System.out.printf("%5s|%15s|%7s|\n","Name","Email","age");
        System.out.printf("+=====+===============+=======+\n");
        for( Student var : arrStudy){
            System.out.printf("|%5s|%15s|%7d|\n",var.getName(),var.getEmail(),var.getAge());
            System.out.printf("+=====+===============+=======+\n");
        }
    }
    
}
