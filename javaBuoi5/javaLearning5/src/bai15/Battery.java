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
public class Battery {
    private int energy;
    
    public Battery(){
    }
    
    public void setEnergy(int energy){
        this.energy = energy;
    }
    
    public int getEnergy(){
        return energy;
    }
    
    public void decreaseEnergy(){
        this.energy = energy -2;
    }
}
