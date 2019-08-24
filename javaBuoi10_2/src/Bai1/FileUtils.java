/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;
import java.io.*;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
/**
 *
 * @author Student
 */
public class FileUtils {
    private String filePath = null;
    private File folder;
    private String[] tailImg = {".png", ".pjg", ".jpeg"};
    public FileUtils(){    
    }
    
    public FileUtils(String filePath){
        this.filePath = filePath;
    }
    
    public void listAllFile(String filePath){
        try{
            this.folder = new File(filePath);
            File[] file = folder.listFiles();
            System.out.println("File");
            for( File var : file){
                if(var.isFile())
                    System.out.println("Name: "+var.getName());
            }
        }
        catch(NullPointerException e){
            System.out.println("khong co file hay folder");
        }
         
    }
    
    public void listAllFolder(String filePath){
        try
        {
            this.folder = new File(filePath);
            File[] file = folder.listFiles();
            System.out.println("Folder");
            for( File var : file){
                if(!var.isFile())
                    System.out.println("   Name: "+var.getName());
            }
        }
        catch(NullPointerException e){
            System.out.println("khong co file hay folder");
        }
    }
    
   private boolean isImagne(String nameOfName){
        for( String var : tailImg)
            if(nameOfName.endsWith(var))
                return true;
        return false;
    }
    
    
    public void listAllImagne(String filePath){
       try
        {
           this.folder = new File(filePath);
            File[] file = folder.listFiles();
            System.out.println("ANH: ");
            for( File var : file){
                if(var.isFile())
                  if(isImagne(var.getName()))
                        System.out.println("   Name: "+var.getName());
            }
        }
        catch(NullPointerException e){
            System.out.println("khong co file hay folder");
        }
    }
    
    public void listAllTimeupDate(String filePath){
       try
        {
            this.folder = new File(filePath);
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            System.out.println(" -Name: "+folder.getName()+" -Time: "+
                   sdf.format(folder.lastModified()) );
        }
        catch(NullPointerException e){
            System.out.println("khong co file hay folder");
        }
    }
    
    public void listAllSizeOfFile(String filePath){
        try
        {
           this.folder = new File(filePath);
            File[] file = folder.listFiles();
            System.out.println("Size of file: ");
            for( File var : file){
                int sizeOfFile = (int) Math.round(var.length()/1000);
                System.out.println(" -Name: " + var.getName() +" /Size: " + sizeOfFile + "kb");
                
            }
        }
        catch(NullPointerException e){
            System.out.println("khong co file hay folder");
        }
    }
}
