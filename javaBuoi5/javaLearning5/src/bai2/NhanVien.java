/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;
import java.util.*;


public class NhanVien {
    private String namNV, addrNV;
    private int ageNV, salNV, timeWork;
    private Scanner readkey = new Scanner(System.in);
    
    public NhanVien(){}
    
    public NhanVien( int ageNV, int salNV, int timeWork, 
            String namNV, String addrNV)
    {
        this.namNV    = namNV;
        this.addrNV   = addrNV;
        this.ageNV    = ageNV;
        this.salNV    = salNV;
        this.timeWork = timeWork;
    }

    public String getNamNV() {
        return namNV;
    }

    public void setNamNV(String namNV) {
        this.namNV = namNV;
    }

    public String getAddrNV() {
        return addrNV;
    }

    public void setAddrNV(String addrNV) {
        this.addrNV = addrNV;
    }

    public int getAgeNV() {
        return ageNV;
    }

    public void setAgeNV(int ageNV) {
        this.ageNV = ageNV;
    }

    public int getSalNV() {
        return salNV;
    }

    public void setSalNV(int salNV) {
        this.salNV = salNV;
    }

    public int getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(int timeWork) {
        this.timeWork = timeWork;
    }
    
    public void inputInfo()
    {
         System.out.println("Nhap thong tin nhan vien: ");
         System.out.print("Ten nhan vien: ");
         namNV = readkey.nextLine();
         this.setNamNV(namNV);
         System.out.print("Dia chi: ");
         addrNV = readkey.nextLine();
         this.setAddrNV(addrNV);
      //   readkey.nextInt();
        //System.in("stdin");
         System.out.print("Tuoi: ");
         ageNV = readkey.nextInt();
         this.setAgeNV(ageNV);
         System.out.print("Tien thương: ");
         salNV = readkey.nextInt();
         this.setSalNV(salNV);
         System.out.print("So gio lam: ");
         timeWork = readkey.nextInt();
         this.setTimeWork(timeWork);
       
    }
    
    
    public float tinhThuong()
    {
        if( this.getTimeWork() >= 200)
            return (float) (this.getSalNV()*this.getTimeWork()*0.2);
        if( this.getTimeWork() < 100)
            return 0;
        if( this.getTimeWork() <= 200)
            return (float) (this.getSalNV()*this.getTimeWork()*1.1);
        return 0;
    }
    
    public void printInfo()
    {
        System.out.println("/*Ket qua:------------------------------------------");
        System.out.println("/*Ten: " + this.getNamNV());
        System.out.println("/*Tuoi: " + this.getAgeNV());
        System.out.println("/*Luong thuong: " + this.getSalNV());
        System.out.println("/*So gio lam: " + this.getTimeWork());
        System.out.println("/*Thuong: " + this.tinhThuong());
        System.out.println("/*--------------------------------------------------");
    }
}
