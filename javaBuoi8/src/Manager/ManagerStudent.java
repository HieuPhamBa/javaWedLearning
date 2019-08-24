package Manager;
public class ManagerStudent extends Manager{
    Student myStudy = new Student();

    public ManagerStudent() {
         this.list = new Student[20];
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
            if(myPer == null)
                break;
            this.showInfo();
        }
        return ;
       
    }

    public void showInfo(){
         System.out.println("Name: "+myStudy.getName()+" Email: "+myStudy.getEmail()+" ID: "+myStudy.getId());
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
