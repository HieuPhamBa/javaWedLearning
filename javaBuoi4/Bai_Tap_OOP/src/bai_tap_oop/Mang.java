/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_tap_oop;
import java.util.*;

public class Mang {
    private int[] intArr  = new int[15];
    private int calEven, calOdd;
    private int max, min;
    private int indexArr;
    
    
    public Mang(){}
    
    public void inputArray(int n)
    {
        this.indexArr = n;
        Scanner readKey = new Scanner(System.in);
        System.out.println("Nhap phan tu: ");
        for( int i=0; i < this.indexArr; i++)
            this.intArr[i] = readKey.nextInt();
    }
    
    public void cal_even_odd()
    {
        this.calEven = 0;
        this.calOdd = 0;
        for( int num : this.intArr)
            if( num%2 == 0)
                this.calEven++;
            else
                this.calOdd++;
    }
    
    public void find_Max_Min()
    {
        this.max = this.min = this.intArr[0];
        for( int num: this.intArr){
            if( num > this.max)
                this.max = num;
            else
                this.min = num;
        }
    }
    
    public void checkNumBai3(int numCheck)
    {
        int flag = 0;
        for( int i=0; i<this.indexArr; i++)
        {
            if( numCheck == this.intArr[i])
            {
                if( flag == 0)
                    System.out.print("Vi tri trung: ");
                System.out.print(" "+i+",");
                flag = 1;
            }
        }
        if( flag == 0)
            System.out.println(numCheck+" Khong trung voi phan tu trong mang");
        System.out.println("");
    }
    
    public void randomArr()
    {
        Random radom = new Random();
        for(int i=0; i<15; i++)
        {
            this.intArr[i] = radom.nextInt(100);
        }
           
    }
    
    public void sort_Arr_Ascending()
    {
        for( int i=0; i<14; i++)
        {
            for( int j=i+1; j<15; j++)
                if( this.intArr[i] < this.intArr[j])
                {
                    int temp = this.intArr[i];
                    this.intArr[i] = this.intArr[j];
                    this.intArr[j] = temp;
                }
        }
    }
    
    public void sort_Arr_Decrease()
    {
        for( int i=0; i<14; i++)
        {
            for( int j=i+1; j<15; j++)
                if( this.intArr[i] > this.intArr[j])
                {
                    int temp = this.intArr[i];
                    this.intArr[i] = this.intArr[j];
                    this.intArr[j] = temp;
                }
        }
    }
  
    public void showArray()
    {
        System.out.println("Mang : ");
        for( int num: this.intArr)
            System.out.print(" "+num);
        System.out.println("");
    }
    
    public void showInforBai2()
    {
        System.out.println("Ket qua:");
        System.out.println("Gia tri Max : "+this.max);
        System.out.println("Gia tri Min : "+this.min);
    }
    
    public void showInforBai1()
    {
        System.out.println("Ket qua:");
        System.out.println("So chan: "+this.calEven);
        System.out.println("So le: "+this.calOdd);
    }
}
