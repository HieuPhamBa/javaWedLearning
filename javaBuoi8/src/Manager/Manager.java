/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import java.util.Scanner;

public abstract class Manager {
    protected Scanner myScan = new Scanner(System.in);
    protected int curr =0;
    protected Person[] list = null;
    public abstract void add();
    public abstract void show();
    public abstract void search(String name);
}
