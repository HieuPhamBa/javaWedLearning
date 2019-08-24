/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;
import java.util.Scanner;
/**
 *
 * @author PhamBaHieu
 */
public class Task {
    private int id;
    private String content, title;
    private boolean done;
    public Scanner myScan = new Scanner(System.in);
    public Task() {
    }

    public Task(int id, String content, String title, boolean done) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    
    public void inputTask(){
        try{
            System.out.println("ID>");
            id = Integer.parseInt(myScan.nextLine());
            this.setId(id);
            System.out.println("Title>");
            title = myScan.nextLine();
            this.setTitle(title);
            System.out.println("Content>");
            content = myScan.nextLine();
            System.out.println("Done ???\n 1: true 0: false");
            int done = Integer.parseInt(myScan.nextLine());
            this.setDone(done==1?true:false);
        }catch(Exception e){
            
        }
        
    }
    @Override 
    public String toString(){
        return this.id +"| " + this.content+"| "+this.title+"| " + this.done;
    }
}
