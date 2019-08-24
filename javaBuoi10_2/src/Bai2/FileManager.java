/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.awt.AWTException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import Bai2.FileManager.*;
/**
 *
 * @author PhamBaHieu
 */
public class FileManager extends SimpleVim{
  
    public void Menu(){
        System.out.println("mkDir: create file.");
        System.out.println("Cat: read File.");
        System.out.println("nano: write to file: ");
    }
    public void manager() throws IOException{
        SimpleVim simpManager = new SimpleVim();
        String filePath = "C:\\Users\\PhamBaHieu\\Desktop\\text.txt";
        String comand;
        System.out.print("Input your file path>");
        filePath = this.myScan.nextLine();
        while(true)
        {
            comand = this.myScan.nextLine();
            switch(comand){
                case "mkDir":
                    simpManager.initNew(filePath);
                    break;
                case "Cat":
                    simpManager.readFile(filePath);
                    break;
                case "nano":
                    simpManager.readFile(filePath);
                    simpManager.intputFile(filePath);
                    break;
                case "help":
                    this.Menu();
                    break;
                default:
                    System.out.println("Unknow "+comand);
                    break;
            }
            System.out.println("");
        }
        
    }
}
