/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

public class ManagerEmployee extends Manager{
    Employee myStudy = new Employee();

    public ManagerEmployee() {
        this.list = new Person[20];
    }
    
    @Override
    public void add() {
       myStudy.input();
       this.list[this.curr] = myStudy;
       this.curr = curr+1;
       return ;
    }

    @Override
    public void show() {
        for(Person myPer : list){
            if(myPer==null)
              break;
            this.showInfo();
        }
       
    }

    public void showInfo(){
         System.out.println("Name: "+myStudy.getName()+" Email: "+myStudy.getSalary()+" ID: "+myStudy.getId());
    }
    
    
    @Override
    public void search(String name) {
      for( Person myPer : list){
          if(myPer==null)
              break;
          if(name.equals(myPer.getName()))
          {
              this.showInfo();
              return ;
          }
      }
        System.out.println("Not valid!!!");
    }
}
