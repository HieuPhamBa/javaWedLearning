/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai19;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Shop {
    private ArrayList<Product> arrPro = new ArrayList<Product>();
    private Product myPro = new Product();
    Scanner readKey = new Scanner(System.in);
    public Shop(){
    }
    
    public void addProduct(){
        int rate, price;
        readKey.nextLine();
        System.out.println("THEM MAT HANG: ");
        System.out.print("Nhap ten phan mat hang>");
        String name = readKey.nextLine();
        myPro.setName(name);
        System.out.print("Mo ta: ");
        String des = readKey.nextLine();
        myPro.setDes(des);
        
        System.out.print("Gia: ");
        do{
            price = readKey.nextInt();
        }while(price<0||price>100);
        myPro.setPrice(price);
         
        System.out.print("Danh gia: ");
        do{
            rate = readKey.nextInt();
        }while(rate<0||rate>=5);
        myPro.setRate(rate);
        
        arrPro.add(myPro);
    }
    
    public void removeProduct(){
        boolean status = false;
         readKey.nextLine();
        System.out.println("Xoa san pham: ");
        System.out.print("Nhap ten : ");
        String tempNam = readKey.nextLine(); 
        for( int i=0; i<arrPro.size(); i++)
            if(tempNam.equals(arrPro.get(i).getName()) == true){
                    arrPro.remove(arrPro.get(i));
                    status = true;
            }
        if(!status)
            System.out.println("Khogn tim thay");
        
    } 
    
    public void searchProduct(){
        int start, end;
        System.out.println("Nhap 2 so bat dau va ket thuc: ");
        start = readKey.nextInt();
        end   = readKey.nextInt();
        if(start>end)
        {
            int temp = start;
            start = end;
            end   = temp;
        }
        for(int i=start; i<end; i++)
            arrPro.get(i).viewInfo();
                    
    }
    
    public void sortProduct(){
         
        for( int i=0; i<arrPro.size(); i++)
            for( int j=i+1; j<arrPro.size(); i++)
            {
                if( arrPro.get(i).getPrice()<arrPro.get(j).getPrice())
                {
                    ArrayList<Product> myPro = new ArrayList<Product>();
                    myPro.add(arrPro.get(i));
                    arrPro.set(j,arrPro.get(i));
                    arrPro.set(i, myPro.get(0));
                    
                    
                } 
            }
    }
    
    public void iterateProductList(){
        System.out.println("HIEN THI SAN PHAM: ");
        for( int i=0; i<arrPro.size(); i++)
            arrPro.get(i).viewInfo();
    }
    
    public void menu(){
        System.out.println("MENU: ");
        System.out.println("1. Add new product.");
        System.out.println("2. Remove product.");
        System.out.println("3. Iterate product list");
        System.out.println("4. Search product");
        System.out.println("5. Sort product");
        System.out.println("6. Exit");
        System.out.println("");
        System.out.print("Moi chon: ");
        int op = readKey.nextInt();
        
        if(op==1)
            this.addProduct();
        else if(op==2)
            this.removeProduct();
        else if(op==3)
            this.iterateProductList();
        else if(op==4)
            this.searchProduct();
        else if(op==5)
            this.sortProduct();
        else if(op==6)
            System.exit(0);
        menu();
    }
    
}
