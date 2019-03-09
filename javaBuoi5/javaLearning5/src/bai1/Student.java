package bai1;
import java.util.*;

public class Student
{
    private String maSV, nameClass;
    private int ageSV;
    private float coreSV;
    final static Scanner readkey = new Scanner(System.in);
    
    public Student(){}

    public Student(String maSV, String nameClass, int ageSV, float coreSV) {
        this.maSV = maSV;
        this.nameClass = nameClass;
        this.ageSV = ageSV;
        this.coreSV = coreSV;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public int getAgeSV() {
        return ageSV;
    }

    public void setAgeSV(int ageSV) {
        this.ageSV = ageSV;
    }

    public float getCoreSV() {
        return coreSV;
    }

    public void setCoreSV(float coreSV) {
        this.coreSV = coreSV;
    }
    
    public void inputInfor()
    {
        System.out.println("Nhap thong tin: ");
        do
        {
            System.out.print("Nhap ma sinh vien: ");
            maSV = readkey.nextLine();
        }
        while(maSV.length() != 8);
        this.setMaSV(maSV);
        
        do
        {
            System.out.print("Diem trung binh: ");
            coreSV = readkey.nextFloat();
        }
        while( coreSV >= 10.0 && coreSV <0 );
        this.setCoreSV(coreSV);
        
        do
        {
            System.out.print("Nhap tuoi: ");
            ageSV = readkey.nextInt();
            readkey.nextLine();
        }
        while(ageSV < 18);
        this.setCoreSV(coreSV);
        
        do
        {
            System.out.print("Nhap lop: ");
            nameClass = readkey.nextLine();
        }
        while( nameClass.charAt(0) != 'A' && nameClass.charAt(0) != 'C' );
        this.setNameClass(nameClass);
    }
    
    public boolean check_hoc_bong()
    {
        if( this.getCoreSV() >= 8.0)
            return true;
        return false;
    }
    
    public void showInfo()
    {
        System.out.println("/-----------------Ket qua--------------");
        System.out.println("/*Ma sinh ven: " + this.getMaSV());
        System.out.println("/*Diem trung binh: " + this.getCoreSV());
        System.out.println("/*Tuoi: " + this.getAgeSV());
        System.out.println("/*Lop: " + this.getNameClass());
        if(check_hoc_bong())
            System.out.println("Duoc hoc bong nhe!!!");
        else
            System.out.println("Eo duoc dau!!!");
    }
}
