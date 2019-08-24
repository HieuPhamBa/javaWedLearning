package buoiCN;
import java.util.Scanner;
public class SmartPhone extends Product{
    private boolean hasCamera;
    private int sim;

    public SmartPhone(boolean hasCamera, int sim) {
        this.hasCamera = hasCamera;
        this.sim = sim;
    }

    public SmartPhone() {
    }

    public boolean isHasCamera() {
        return hasCamera;
    }

    public void setHasCamera(boolean hasCamera) {
        this.hasCamera = hasCamera;
    }

    public int getSim() {
        return sim;
    }

    public void setSim(int sim) {
        this.sim = sim;
    }
    
    private boolean convertToBool(int key)
    {
        if(key==1)
            return true;
        return false;
    }
    
    @Override
    public void addNew(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("---Nhap thong tin smartphone---");
        System.out.println("Co sim???");
        System.out.println("1. co      2. khong");
        int hasCam = myScanner.nextInt();
        this.setHasCamera(convertToBool(hasCam));
        System.out.println("Sim>");
        sim = myScanner.nextInt();
        this.setSim(sim);
        myScanner.nextLine();
        super.addNew();
    }
    @Override
    public void showInfo(){
        super.showInfo();
        System.out.printf("%11d|%5s|\n", this.getSim(), this.isHasCamera());
    }
}
