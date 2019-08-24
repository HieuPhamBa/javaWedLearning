/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai11;
import java.util.Scanner;
/**
 *
 * @author PhamBaHieu
 */
public class Matrix {
    private int witdh, height;
    private int[][] valMatrix;
    
    public Matrix(){
    }
    
    public Matrix( int with, int height){
        this.height    = height;
        this.witdh     = witdh;
        this.valMatrix = new int[height][witdh];
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
    
     public int[][] getValMatrix() {
        return valMatrix;
    }
     public void setValMatrix(int valMatrix, int i, int j) {
        this.valMatrix[i][j] = valMatrix;
    }
    
    public void setValMatrix(int[][] valMatrix) {
        this.valMatrix = valMatrix;
    }
    
    
    public void inputMatrix()
    {
        valMatrix = new int[height][witdh];
        System.out.println(" "+this.height+" "+this.witdh);
        Scanner readKey = new Scanner(System.in);
        System.out.println("Nhap ma tran: ");
        for( int i=0; i<this.height; i++)
            for( int j=0; j<this.witdh; j++)
                valMatrix[i][j] = readKey.nextInt();
        this.setValMatrix(valMatrix);
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
