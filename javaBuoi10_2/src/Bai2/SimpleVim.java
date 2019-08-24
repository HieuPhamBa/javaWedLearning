/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Student
 */
public class SimpleVim {
    private String filePath = null;
    public Scanner myScan = new Scanner(System.in);
    private File folder;
    
    public SimpleVim(){
        
    }
    
    public SimpleVim(String filePath){
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public File getFolder() {
        return folder;
    }

    public void setFolder(File folder) {
        this.folder = folder;
    }
    
    public void initNew(String filePath) {
        try{
            this.folder = new File(filePath);
            System.out.println("Nhap ten file>");
            String contFile = myScan.nextLine();
            filePath = filePath+ "//"+ contFile;
            folder = new File(filePath);
            this.getFilePath();
            if(this.folder.createNewFile())
                System.out.println("Tao file thanh cong!!!");;
        }catch(Exception e){
            System.out.println("Duong dan khong tont ta!!");
        }
        intputFile(this.filePath);
    }
    
    public void intputFile(String filePath) {
       try{
           boolean order;
           String text = "";
           folder = new File(filePath);
           FileWriter fw = new FileWriter(folder.getAbsoluteFile(),true);
           BufferedWriter bw;
           bw = new BufferedWriter(fw);
           while(true){
               text = myScan.nextLine();
               if(checkOrder(text)==1)
               {    
                   String[] strOutput = text.split(":wq");
                   byte [] byteText = strOutput[0].getBytes();
                   writeTofile(byteText,bw);
                   bw.close();
                   System.exit(0);
                   break;
               }
               else if(checkOrder(text)==0)
               {
                   bw.close();
                   break;
               }
           }
         
       }catch(FileNotFoundException e){
            e.printStackTrace();
       }catch(IOException e){
            e.printStackTrace();
       }
    }
    private void writeTofile(byte byteText[], BufferedWriter bw) throws IOException{
         for(byte x: byteText)
               bw.write(x);
         
    }
    
    public void readFile(String filePath) throws IOException {
        FileInputStream fin;
        folder = new File(filePath);
        if(folder.exists()){
            fin = new FileInputStream(folder);
            int size = fin.available();
            for(int i=0; i<size; i++){
                System.out.print((char)fin.read());
            }
        }
        else{
            System.out.println("Khong ton tai file");
        }
      
    }
    private int checkOrder(String text){
        if(text.endsWith(":q")){
            return 0;
        }else if(text.endsWith(":wq"))
            return 1;
        return -1;
    }

}
