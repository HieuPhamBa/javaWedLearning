package buoiCN;
import java.util.Scanner;
public class Store {
    private Product[] arrProduct = new Product[100];
    private int numPro = 0;
    private static Scanner myScan = new Scanner(System.in);

    public Store() {
    }

    public Store(Product[] arrProduct) {
        this.arrProduct = arrProduct;
    }

    public Product[] getArrProduct() {
        return arrProduct;
    }

    public void setArrProduct(Product[] arrProduct) {
        this.arrProduct = arrProduct;
    }

    public int getNumPro() {
        return numPro;
    }

    public void setNumPro(int numPro) {
        this.numPro = numPro;
    }
    
    public void add()
    {
        Product myPro = new  Product();
        System.out.println("Moi ban chon: ");
        System.out.println("1.SmartPhone   2.Camera");
        int option = myScan.nextInt();
        switch(option){
            case 1:
                myPro = new Camera();
                break;
            case 2:
                myPro = new SmartPhone();
                break;
            default:
                System.out.println("Moi chon lai !!!");
                add();
                break;
        }
        myPro.addNew();
        arrProduct[numPro] =  myPro;
        numPro++;
        this.setNumPro(numPro);
    }
    
    public void list(){
          System.out.printf("%15s|%5d|%5f|%5s", "Name", "ID",
                "Gia", "Chat luong");
          for(Product var : arrProduct)
          {
              var.showInfo();
          }
    }
    
    public void search()
    {
        System.out.println("Nhap vao 1 ten>");
        String name = myScan.nextLine();
        System.out.printf("%15s|%5d|%5f|%5s", "Name", "ID",
                "Gia", "Chat luong");
        for(Product var : arrProduct)
            if(name.equals(var.getName()))
            {
                var.showInfo();
                return ;
            }
        System.out.println("Khong tim thay :<.");
    }
}
