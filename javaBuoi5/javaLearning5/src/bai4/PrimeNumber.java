package bai4;
import java.util.Scanner;
public class PrimeNumber {
    private int a;
    public PrimeNumber(){
    }
    public PrimeNumber(int a){
        this.a = a;
    }  
    
    public void setPrimeNumber(int a)
    {
        this.a = a;
    }
    
    public int getPrimeNumber()
    {
        return a;
    }
    
    public boolean is_Prime(int num)
    {
        if(num<2)
            return true;
        else
        {
            int squaNum = (int) Math.sqrt(num);
            for( int i=2; i<=squaNum; i++){
                if(num%i==0)
                    return false;
            }
        }
        return true;
    }
    public void inputNum()
    {
        Scanner readKey = new Scanner(System.in);
        System.out.print("Nhap so a>");
        a = readKey.nextInt();
        if(this.is_Prime(a))
        {
            System.out.println("Day la so nguyen to.");
            this.setPrimeNumber(a);
        }       
        else 
            System.out.println(a+" Khong la so nguyen to");
    }
    
    public int nextPrime()
    {
        int nextNum = this.a;
        while(true)
        {
            nextNum++;
            if(this.is_Prime(nextNum))
                return nextNum;
        }
    }
}
