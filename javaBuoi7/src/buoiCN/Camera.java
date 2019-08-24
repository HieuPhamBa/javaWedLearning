/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoiCN;
import java.util.Scanner;
/**
 *
 * @author PhamBaHieu
 */
public class Camera extends Product{
    private boolean hasWifi;
    
    public Camera(){
    }
    
    public Camera(boolean hasWifi){
        this.hasWifi = hasWifi;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }
    
    public boolean convertToBool(int key)
    {
        if(key==1)
            return true;
        return false;
    }
    
    public void addNew(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("---Nhap thong tin Camera---");
        System.out.println("Co wifi???");
        System.out.println("1. co      2. khong");
        int hasWifi  = myScanner.nextInt();
        this.setHasWifi(convertToBool(hasWifi));
        super.addNew();
        return ;
    }
    
    public void showInfo(){
        super.showInfo();
        System.out.printf("%5s|\n", this.isHasWifi());
    }
}
