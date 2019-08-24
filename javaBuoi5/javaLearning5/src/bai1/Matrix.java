/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;
import java.util.Scanner;
/**
 *
 * @author PhamBaHieu
 */
public class Matrix {
    private int witdh, height;
    private int[][] valMatrix;
    
    Matrix matr1 = new Matrix();
    Matrix matr2 = new Matrix();
    public Matrix(){
    }
    
    public Matrix( int with, int height){
        this.height    = height;
        this.witdh     = witdh;
    }

    public int getWitdh() {
        return witdh;
    }

    public void setWitdh(int witdh) {
        this.witdh = witdh;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getValMatrix(int i, int j) {
        return valMatrix[i][j];
    }

    public void setValMatrix(int[][] valMatrix) {
        this.valMatrix = valMatrix;
    }
    
    
    public void inputMatrix()
    {
      
        Scanner readKey = new Scanner(System.in);
        System.out.print("Nhap chieu cao>");
        height = readKey.nextInt();
        System.out.print("Nhap chieu dai>");
        witdh = readKey.nextInt();
        for( int i=0; i<height; i++)
            for( int j=0; j<witdh; j++)
                valMatrix[i][j] = readKey.nextInt();
    }
    
    public void outputMatrix()
    {
        System.out.println("Ket qua: ");
        for(int i=0; i<height; i++)
        {
            for(int j=0; j<witdh; j++)
                System.out.print(" "+this.getValMatrix(i, j));
            System.out.println("");
        }
    }
}
