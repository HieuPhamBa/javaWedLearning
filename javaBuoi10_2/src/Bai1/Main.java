/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author Student
 */
public class Main {
    public static void main(String[] args) {
        String filepath1 = "C:\\Users\\Student\\Downloads\\DVWA";
        String filepath = "C:\\myFile";
        FileUtils fileManager = new FileUtils();
        fileManager.listAllFolder(filepath);
        fileManager.listAllTimeupDate(filepath);
        fileManager.listAllSizeOfFile(filepath);
    }
}
