/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package log1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Roberto
 */
public class Log1 {
    
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    String[] text = {"Busy Port",
        "Port not reachable",
        "File does not exist",
        "Invalid path",
        "Server not Responding",
        "Unexpected Error",
        "Memory Error",
        "Read Error",
        "Write error"};
    
    synchronized void writerBot( ){
        
        Random rand = new Random();
        int message = (rand.nextInt(9)) - 1 ;
        
        lock.writeLock().lock();
        
        
        try {
            FileWriter myWriter = new FileWriter("src\\filename.txt" , true);
            myWriter.write(text[message] + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }finally{
            
            lock.writeLock().unlock();
            
        }
        
    }
    
    synchronized void readerBot(){
        
        lock.readLock().lock();
        
        
        
        try {
            
            File myObj = new File("src\\filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
        }
        myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }finally{
            lock.readLock().unlock();
        }
        
        
    }
    
}