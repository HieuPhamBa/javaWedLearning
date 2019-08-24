package BuoiThu7;
import java.util.Scanner;
public class Main {
 
    public static void menu()
    {
        System.out.println("Moi chon:");
        System.out.println(" 1. Add.");
        System.out.println(" 2. Search.");
        System.out.println(" 3. List.");
        System.out.println(" 4 exit.");
        System.out.println("Moi ban chon: ");
    }
    public static boolean convert(int key)
    {
        if( key == 1){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ManagerStudent myMan = new ManagerStudent();
        Scanner myScan = new Scanner(System.in);
        while(true){
            menu();
            int op = myScan.nextInt();
            switch(op){
                case 1:
                    myMan.add();
                    myMan.outputArrayList();
                    break;
                case 2: 
                    myMan.search();
                    break;
                case 3:
                    System.out.println("Moi ban chon:");
                    System.out.println("1.tang dan   2.giam dan");
                    int myOp = myScan.nextInt();
                    myMan.list(convert(myOp));
                    myMan.outputArrayList();
                    break;
                case 4:
                    System.exit(0);
                    
            }
      
        }
      
    }
}
