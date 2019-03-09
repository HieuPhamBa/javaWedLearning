/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai6;

/**
 *
 * @author PhamBaHieu
 */
public class Rect {
    private int longEdge, wideEdge;

    public Rect() {
    }

    public Rect(int longEdge, int wideEdge) {
        this.longEdge = longEdge;
        this.wideEdge = wideEdge;
    }

    public int getLongEdge() {
        return longEdge;
    }

    public void setLongEdge(int longEdge) {
        this.longEdge = longEdge;
    }

    public int getWideEdge() {
        return wideEdge;
    }

    public void setWideEdge(int wideEdge) {
        this.wideEdge = wideEdge;
    }
    
    public void showInfo(){
        System.out.println("HINH CHU NHAT: ");
        System.out.println("Chu vi: "+(this.getLongEdge()*2+this.getWideEdge()*2));
        System.out.println("Dien tich: "+(this.getLongEdge()*this.getWideEdge()));
    }
}
