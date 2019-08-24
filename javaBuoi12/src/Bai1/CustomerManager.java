/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.NotSerializableException;
import java.util.*;
public class CustomerManager implements Serializable {
    private ArrayList<Customer> listCus = new ArrayList<Customer>();
    private int numCus = 0;
    private Customer cus = new Customer();
    public void add(){
        String name, id, age, addres;
       try{
            System.out.println("-----------Nhap------------");
            System.out.print("Nhap id>");
            cus.setId(Integer.parseInt(new Scanner(System.in).nextLine()));
            System.out.print("Nhap ten>");
            cus.setName(new Scanner(System.in).nextLine());
            System.out.print("Nhap dia chi>");
            cus.setAddress(new Scanner(System.in).nextLine());
            System.out.print("Nhap tuoi>");
            cus.setAge(Integer.parseInt(new Scanner(System.in).nextLine()));
       }catch(Exception e){
       }
        System.out.print("Co muon luu khong???\n y. co\t n.No");
        boolean choice = (new Scanner(System.in).nextLine()).equals("y");
       
        if(choice)
            if(save())
                System.out.println("Luu thành công");
            else
                System.out.println("Lưu thât bại.");

    }
    private boolean save(){
        File f = new File("C:\\Bai12\\CusList.dat");
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oCus = new ObjectOutputStream(fos);
            oCus.writeObject(this.cus);
            this.numCus = numCus+1;
            fos.close();
            oCus.close();
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
            return false;
        }catch(IOException ioe){
            System.out.println(ioe.toString());
            return false;
        }
        return true;
    }
    
    public boolean load(){
        File f = new File("C:\\Bai12\\CusList.dat");
        try{
            FileInputStream fis = new  FileInputStream(f);
            ObjectInputStream oCus = new ObjectInputStream(fis);
            for( int i=0; i<numCus; i++){
                cus = (Customer) oCus.readObject();
                listCus.add(cus);
            }
            fis.close();
            oCus.close();
        }
        catch(FileNotFoundException efnf){
            return false;
        }
        catch(IOException ioe){
            return false;
        }
        catch (ClassNotFoundException ex) {
            return false;
        }
        return true;
    }
    
    public Customer Search(){ 
        if(load()){
            System.out.println("Load thanh cong!!!!!!");
        }else{
            System.out.println("Load that bai!!!");
        }
        
        System.out.println("Nhap id muon tim kiem>");
        int id = (new Scanner(System.in).nextInt());
        
        for(Customer cusTemp:listCus){
            if(cusTemp.getId()==id)
                return cusTemp;
        }
        return null;  
    }
    
    public void output(){
        if(load()){
            System.out.println("Load thanh cong!!!!!!");
        }else{
            System.out.println("Load that bai!!!");
        }
        
         
        for(Customer cusTemp:listCus){
            System.out.println(cusTemp);
        }
    }
}
