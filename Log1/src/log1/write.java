
package log1;

import java.io.File;
import java.io.IOException;


public class write {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        File myObj = new File("src\\filename.txt");
        if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
        } else {
        System.out.println("File already exists.");
        
        }
        
        readWrite Billy = new readWrite();
        
         new Thread(){
            @Override
            public void run(){
                
                Billy.writerBot();
                Billy.writerBot();
                Billy.writerBot();
                Billy.writerBot();
                
            }
        }.start();
         
         new Thread(){
            @Override
            public void run(){
                Billy.readerBot();
            }
        }.start();
        
    }
    
}