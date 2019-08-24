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
public class MyPoint {
    private int x, y;

    public MyPoint() {
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    public void setYX(int y) {
        this.y = y;
    }
    
    public String toString(){
        return "("+x+","+y+")";
    }
    
    public double distance(int x, int y){
        int xDis = Math.abs(this.getX() - x);
        int yDis = Math.abs(this.getY() - y);
        return Math.sqrt(Math.pow(yDis,2)+Math.pow(xDis, 2));
    }
    
    public double distance(MyPoint myPoint){
        int xDis = Math.abs(this.getX() - myPoint.getX());
        int yDis = Math.abs(this.getY() - myPoint.getY());
        return Math.sqrt(Math.pow(yDis,2)+Math.pow(xDis, 2));
    }
    
    
    
}
