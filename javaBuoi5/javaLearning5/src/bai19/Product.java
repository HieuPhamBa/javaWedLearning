/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai19;

/**
 *
 * @author PhamBaHieu
 */
public class Product {
    private String name;
    private String des;
    private double price;
    private int rate;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
    public void viewInfo(){
        System.out.println("Ket qua: ");
        System.out.println("Ten: "+this.getName());
        System.out.println("Mo ta: "+this.getDes());
        System.out.println("Gia: "+this.getPrice());
        System.out.println("Danh gia: "+this.getRate());
        
    }
    
}
