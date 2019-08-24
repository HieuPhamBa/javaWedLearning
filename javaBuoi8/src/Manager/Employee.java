/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

/**
 *
 * @author PhamBaHieu
 */
public class Employee  extends Person {
    private String salary;

    public Employee() {
    }

    public Employee(String salary) {
        this.salary = salary;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
    
    public void input(){
        System.out.println("---Nhap---");
        super.input();
        System.out.print("Nhap luong>");
        salary = myScan.nextLine();
    }
}
