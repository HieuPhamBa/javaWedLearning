// bai 3 phan mang
package bai_tap_oop;
import java.util.*;
/**
 *
 * @author PhamBaHieu
 */
public class bai3 {
    public static void main(String[] args) {
        Mang arr3 = new Mang();
        Scanner readKey = new Scanner(System.in);
        int num;
        arr3.inputArray(5);
        System.out.print("Nhap so muon kiem tra >");
        num = readKey.nextInt();
        arr3.checkNumBai3(num);
    }
}
