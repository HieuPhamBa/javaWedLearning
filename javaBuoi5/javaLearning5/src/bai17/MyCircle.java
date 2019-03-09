/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai17;
import java.util.*;
/**
 *1
 * @author PhamBaHieu
 */
public class MyCircle extends MyPoint{
    private int radias;
    private Scanner readKey = new Scanner(System.in);
    public MyCircle() {
    }

    public MyCircle(int radias, int x, int y) {
        super(x, y);
        this.radias = radias;
    }
    
    public void inputCircle(){
        System.out.print("Nhap ban kinh hinh tron: ");
        radias = readKey.nextInt();
        System.out.println("Hinh tron:");
        System.out.println("Ban kinh: "+this.getRadias());
        System.out.println("Tam : "+this.toString());
    }

    public int getRadias() {
        return radias;
    }

    public void setRadias(int radias) {
        this.radias = radias;
    }
}
