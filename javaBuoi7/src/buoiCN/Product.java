/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoiCN;
import java.util.Scanner;
public class Product {
    private int id;
    private String name;
    private double price;
    private int quan;

    public Product(int id, String name, double price, int quan) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quan = quan;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuan() {
        return quan;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }
    
    public void addNew()
    {
       Scanner myScan = new Scanner(System.in);
       System.out.println("---Nhap---");
       System.out.print("Nhap ten>");
       name = myScan.nextLine();
       this.setName(name);
       System.out.print("Nhap ID>");
       id = myScan.nextInt();
       this.setId(id);
       System.out.print("Nhap Gia>");
       price = myScan.nextDouble();
       this.setPrice(price);
       System.out.print("Chat luong>");
       quan = myScan.nextInt();
       this.setQuan(quan);
       return ;
    }
    
    public void showInfo()
    {
        System.out.printf("%15s|%5d|%5f|%5d", this.getName(), this.getId(),
                this.getPrice(), this.getQuan());
    }
}
