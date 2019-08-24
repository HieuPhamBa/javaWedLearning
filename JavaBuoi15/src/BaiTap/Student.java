/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTap;

public class Student {
    private String id, name;
    private String email, pass;
    
    public Student(){
    }

    public Student( String id, String name, String email, String pass){
        this.id = id;
        this.email = email;
        this.name = name;
        this.pass = pass;
        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public boolean equal(String emailSV, String passSV){
        boolean flag = false;
        flag = email.equals(emailSV)&passSV.equals(passSV);
        return flag;
    }
    
    public String toString(){
        return this.getId()+" |"+this.getName()+" |"+this.getEmail();
    }
}
