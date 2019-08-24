/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai6;
import java.util.*;
/**
 *
 * @author PhamBaHieu
 */
public class Main {
    public static void main(String[] args) {
        Rect myRect = new Rect();
        Scanner readKey = new Scanner(System.in);
        int longEdge = readKey.nextInt();
        myRect.setLongEdge(longEdge);
        int wideEdge = readKey.nextInt();
        myRect.setWideEdge(wideEdge);
        myRect.showInfo();
    }
}
