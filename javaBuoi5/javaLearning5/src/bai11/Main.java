package bai11;

import static bai11.Main.MAX;
import java.util.Scanner;

public class Main {
    static final int  MAX = 100;
    public static int[][] addMa( int arr1[][], int arr2[][], int n, int m){
         int[][] arr3 = new int[n][m];
         for( int i=0; i<n; i++)
            for( int j=0; j<m; j++)
                arr3[i][j] = arr2[i][j]+arr1[i][j];
         return arr3;
    }
    
    public static int[][] multiMa( int arr1[][], int arr2[][], int n, int m){
        int[][] arr3 = new int[n][m];
        int i, j, k, sum;
        for (i = 0; i <m; i++) {
                for (j = 0; j < n; j++) {
                    sum = 0;
                    for (k = 0; k < m; k++) {
                          sum = sum + arr1[i][k] * arr2[k][j];
                    }
                    arr3[i][j] = sum;
                }
          }

        return arr3;
    }
    
    public static void main(String[] args)
    {
        Matrix ma1 = new Matrix();
        Matrix ma2 = new Matrix();
        Matrix ma3 = new Matrix();
        
        Scanner readKey = new Scanner(System.in);
        System.out.print("Nhap chieu cao>");
        int height = readKey.nextInt();
        System.out.print("Nhap chieu dai>");
        int witdh = readKey.nextInt();
        
        ma1.setHeight(height);
        ma1.setWitdh(witdh);
        
        ma2.setHeight(height);
        ma2.setWitdh(witdh);
        
        ma3 = new Matrix(height,witdh);
        ma3.setWitdh(witdh);
        ma3.setHeight(height);
        
        ma1.inputMatrix();
        ma2.inputMatrix();
        
        ma3.setValMatrix(addMa(ma1.getValMatrix(),ma2.getValMatrix(),
                ma1.getHeight(),ma1.getWitdh()));
        ma3.outputMatrix();
        
        ma3.setValMatrix(multiMa(ma1.getValMatrix(),ma2.getValMatrix(),
                ma1.getHeight(),ma1.getWitdh()));
        ma3.outputMatrix();
    }
}
