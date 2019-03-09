/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai17;

/**
 *
 * @author PhamBaHieu
 */
public class Main {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(4,5);
        MyPoint point2 = new MyPoint(3,4);
        System.out.println("Toa do: "+point1.toString());
        System.out.println("Toa do: "+point2.toString());
        
        System.out.println("Khoang cach tu 1-2: "+point1.distance(4,5));
        System.out.println("Khoang cach tu 1-2: "+point2.distance(point1));
        
        
        MyCircle myCir = new MyCircle();
        myCir.setX(point1.getX());
        myCir.setY(point1.getY());
        
        myCir.inputCircle();
    }
}
