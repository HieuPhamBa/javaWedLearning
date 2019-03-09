/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_tap_oop;
import java.util.*;

public class Matrix {
    private int[][] maInt;
    private int height, witdh;
    
    public Matrix( int height, int witdh )
    {
        this.height = height;
        this.witdh =  witdh;
        this.maInt = new int[height][witdh];
    }
    
    public Matrix(){}
    
    public void inputMatrix()
    {
        Scanner readKey = new Scanner(System.in);
        for( int i=0; i < this.height; i++)
            for( int j=0; j < this.witdh; j++)
                maInt[i][j] = readKey.nextInt();
    }
    
    public boolean checkMatrixUnit()
    {
        for( int i=0; i < this.witdh; i++)
            if( maInt[i][i] != 1)
                return false;
        return true;
    }
    
    public boolean checkMatrixZero()
    {
        for( int i=0; i < this.height; i++)
            for( int j=0; j < this.witdh; j++)
                if (this.maInt[i][j] != 0)
                    return false;
        return true;
    }
    
    public boolean checkMatrixSymmetric()
    {
        for( int i=0; i < this.height; i++)
            for( int j=i+1; j < this.witdh; j++)
                if (this.maInt[i][j] != this.maInt[j][i])
                    return false;
        return true;
    }
    
    
    public void showInfo()
    {
        int flag = 0;
        if(this.checkMatrixSymmetric())
        {
            System.out.println("Day la ma tran doi xung");
            flag = 1;
        }
        if(this.checkMatrixUnit())
        {
            System.out.println("Day la ma tran don vi");
            flag = 1;
        }
        if(this.checkMatrixZero())
        {
            System.out.println("Day la ma tran khong");
            flag = 1;
        }
        
        if( flag == 0 )
            System.out.println("Day la ma tran thuong.");
    }
}

