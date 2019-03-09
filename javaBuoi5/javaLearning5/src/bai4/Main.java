/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

/**
 *
 * @author PhamBaHieu
 */
public class Main {
    public static void main(String[] args) {
        PrimeNumber num = new PrimeNumber();
        num.inputNum();
        System.out.println("Next prime: "+num.nextPrime());
    }
}
