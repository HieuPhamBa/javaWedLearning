/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai15;

/**
 *
 * @author PhamBaHieu
 */
public class FlashLamp extends Battery {
    private boolean status;
    private Battery flashBat;
    
    public FlashLamp(){
    }

    public FlashLamp(boolean status, Battery flashBat) {
        this.status = status;
        this.flashBat = flashBat;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Battery getFlashBat() {
        return flashBat;
    }

    public void setFlashBat(Battery b) {
      //  System.out.println("flashBat: "+flashBat.getEnergy());
       // flashBat.setEnergy(24);
       super.setEnergy(b.getEnergy());
    }
    
   
    public boolean getStatus(){
        return status;
    }
    
    public void getBatteryInfo(){
        System.out.println("Batter");
        System.out.println("Pin energy: "+this.getEnergy());
    }
    
    public void turnOn(){
        if(this.getEnergy()>0)
            this.status = true;
        else
            this.status = false;
        this.setStatus(status);
    }
    
    public void turnOff(){
        this.status = false;
    }
}
