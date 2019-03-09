/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai5;

/**
 *
 * @author PhamBaHieu
 */
public class Triangle {
    private int a, b, c;

    public Triangle() {
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    
    public int chuVI(){
        return this.getA()+this.getB()+this.getC();
    }
    public int dienTich(){
        int tempNum = this.chuVI()/2;
        return (int) Math.sqrt(tempNum*(tempNum-this.getA())* (tempNum-this.getB())*(tempNum-this.getC()));
    }
    public void nhanDien(){
        if( this.getA()+this.getB()<this.getC()&& this.getA()+this.getC()<this.getB())
        {
            System.out.println("Dien tich: "+this.dienTich());
            System.out.println("Chu vi:  "+this.chuVI());
            if(this.getA()==this.getB()&& this.getA()==this.getC()&& this.getC()==this.getB())
                System.out.println("Tam giac deu");
            else if(this.getA()==this.getB()|| this.getA()==this.getC()|| this.getC()==this.getB())
                System.out.println("Tam giac can");
        }
    }
}
