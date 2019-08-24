/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Student
 */
public class Customer implements Serializable {
    private int id, age;
    private String name, address;
    
    public Customer(){
    }
    
    public Customer(int age, int id, String name, String address){
        this.age = age;
        this.address = address;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString(){
        return this.id + "| " + this.name + "| "+ this.getAddress() + "| "+ this.age;
    }
}
