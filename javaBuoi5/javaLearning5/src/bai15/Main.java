/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai15;
import java.util.Scanner;
/**
 *
 * @author PhamBaHieu
 */
public class Main {
    public static void main(String[] args) {
        int tempPin;
        Battery myPin = new Battery();
        Scanner readKey   = new Scanner(System.in); 
        FlashLamp myFlash = new FlashLamp();
        System.out.print("Nhap so pin: ");
        tempPin = readKey.nextInt();
        myPin.setEnergy(tempPin);
        myFlash.setFlashBat(myPin);
        myFlash.getBatteryInfo();
        for( int i=0; i<10; i++)
        {
            myFlash.turnOn();
            if(myFlash.getStatus())
                myFlash.decreaseEnergy();
            myFlash.turnOff();
            System.out.println("Lamp off");
        }
        myFlash.getBatteryInfo();
    }
}
