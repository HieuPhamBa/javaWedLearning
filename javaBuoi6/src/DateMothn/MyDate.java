/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateMothn;

import java.util.Scanner;
/**
 *
 * @author Student
 */
public class MyDate {
   private int date, month, years;
   private static final Scanner readKey = new Scanner(System.in);
   
   public MyDate(){
   }
   
   public MyDate(int date, int month, int years){
       this.date  = date;
       this.month = month;
       this.years = years;
   }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
   
   public void inputDMY()
   {
       System.out.print("Nhap ngay>");
       date = readKey.nextInt();
       this.setDate(date);
       System.out.print("Nhap thang>");
       month = readKey.nextInt();
       this.setMonth(month);
       System.out.print("Nhapo nam>");
       years = readKey.nextInt();
       this.setYears(years);  
   }
   
   public int takeNumDay(){
       int sumDay = 0;
       if(this.getMonth()<=2)
           return sumDay = this.getDate() + (this.getMonth()-1)*31;
       if(this.checkYears())
       {
           sumDay = (int) Math.round(((this.getMonth()-1)*30.6)-1) + (int)((this.getYears()-1)*365.25)
                   + this.getDate() -1;
       }
       else 
           sumDay =  (int)Math.round(((this.getMonth()-1)*30.6)-1) + (int)( (this.getYears()-1)*365.25) 
                   + this.getDate() -1; 
       System.out.println("so ngay: "+ sumDay);
       return sumDay;
   }
   
   public void outputDMY()
   {
       System.out.println("Moi chon: ");
       System.out.println("\t1. Dang ngan. ");
       System.out.println("\t2. Dang dai.");
       System.out.print("Moi chon>");
       int op = readKey.nextInt();
       switch(op){
           case 1:
               System.out.println("Dang ngan: " + this.getDate() + "/" + 
                       this.getMonth()+"/" + this.years);
               break;
           case 2:
               System.out.println("Dang dai: Ngay " + this.getDate() + 
                       " Thang " + this.getMonth() + " Nam " +this.getYears());
               break;
       }
   }
   
   public void addDay(int day)
   {
       int sumDay = takeNumDay()+day;
       years = (int) (sumDay/365.25+1);
       this.setYears(years);
       month =(int) ((sumDay - (int) (this.getYears()-1)*365.25)/30.6)+1;
       this.setMonth(month);
       if(checkYears())
            date = sumDay - (int)(( this.getYears()-1)*365.25) 
               - (int)Math.round(((this.getMonth()-1)*30.6)-1) - 2;
       else
            date = sumDay - (int)(( this.getYears()-1)*365.25) 
               - (int)Math.round(((this.getMonth()-1)*30.6)-1)-1;
       this.setDate(date);
   }
   
   public void odđay(int day)
   {
       int sumDay = takeNumDay()+day;
       years = (int) (sumDay/365.25+1);
       this.setYears(years);
       month =(int) ((sumDay - (int) (this.getYears()-1)*365.25)/30.6)+1;
       this.setMonth(month);
       if(checkYears())
            date = sumDay - (int)(( this.getYears()-1)*365.25) 
               - (int)Math.round(((this.getMonth())*30.6)) + 3;
       else
            date = sumDay - (int)(( this.getYears()-1)*365.25) 
               - (int)Math.round(((this.getMonth())*30.6)) + 2;
       this.setDate(date);
   }
   public void takeDate()
   {
       int dateDay = takeNumDay()%7;
       if(dateDay==0)
           System.out.println("Chu nhat");
       else
           System.out.println("Thu: " + (dateDay+1));
   }
   
   public boolean checkYears(){
       if( this.getYears()%400 == 0||
               ( this.getYears()%4 == 0&& this.getYears()%100 != 0) )
           return true;
       return false;
   }
   
   
   public void getNamYear(){
       int tempLastNam  = this.getYears()%12;
       int tempFirstNam = this.getYears()%10;
       
       String[] canChi = { "Canh", "Tân", "Nhâm", "Quí", "giáp", "ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân"};
       String[] namYear = {  "Than", "Dau","Tuot", "Hoi","Ty", "Suu", "Dan", "Mao", "Thin", "Ty", "Ngo", "Mui"};
      
       System.out.println("Ten nam: " + canChi[tempFirstNam] + " " + namYear[tempLastNam] );
       
   }
}
