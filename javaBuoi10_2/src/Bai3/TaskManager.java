/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
/**
 *
 * @author PhamBaHieu
 */
public class TaskManager implements Serializable {
    private ArrayList<Task> listTask;
    private String filePath = new String();
    private Task myTask;
    private FileOutputStream fileOutput;
    private ObjectOutputStream objectOutput;
    private int numObject = 0;
    
    public TaskManager(String filePath) {
        this.filePath = filePath;
        
    }

    public int getNumObject() {
        return numObject;
    }

    public void setNumObject(int numObject) {
        this.numObject = numObject;
    }
    
    public void initObjectFile(String filePath){
        try {
            fileOutput = new FileOutputStream(filePath, true);
            try {
                objectOutput = new ObjectOutputStream(fileOutput);
            } catch (IOException ex) {
                Logger.getLogger(TaskManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            File file = new File(filePath);
            
            try{
                file.createNewFile();
                initObjectFile(filePath);
            }catch(IOException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public void add(String filePath){
        this.initObjectFile(filePath);
        myTask = new Task();
        myTask.inputTask();
        //listTask.add(myTask);
        try {
            objectOutput.writeObject(myTask);
            fileOutput.close();
            objectOutput.close();
        } catch (IOException ex) {
            
        }
        this.numObject = numObject + 1;
        this.setNumObject(this.numObject);
      
    }
    
    public void loadTask(){
        System.out.print("Enter yours path>");
        String filePath = new Scanner(System.in).nextLine();
        try {
            FileInputStream fi = new FileInputStream(filePath);
            ObjectInputStream objectInput = new ObjectInputStream(fi);
             try {
                for(int i=0; i<numObject; i++){
                        myTask = (Task) objectInput.readObject();
                        listTask.add(myTask);
                        fi.close();
                        objectInput.close();
                }
                 System.out.println("Load success!!!!");
            } catch (ClassNotFoundException ex) {
                   
            }
        }catch (IOException e){
            
        }
    }
    public void showAll(String filePath){
        try {
            FileInputStream fi = new FileInputStream(filePath);
            ObjectInputStream objectInput = new ObjectInputStream(fi);
             try {
                for(int i=0; i<numObject; i++){
                        myTask = (Task) objectInput.readObject();
                        System.out.println(myTask.toString());
                }
            } catch (ClassNotFoundException ex) {          
            }
        }catch (IOException e){ 
        }
    }
}
