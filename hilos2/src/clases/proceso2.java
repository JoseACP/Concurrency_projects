package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;
public class proceso2 extends Thread{
    
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private static String[] datos = {"Busy port",
            "Port not reachable",
            "File does not exist",
            "Invalid path",
            "Server not responding",
            "Unexpected error",
            "Memory error",
            "Read error",
            "Write error"};
    
    @Override
    public void run(){

            if (lock.isWriteLocked()) {
                System.out.println("Write Lock Present.");
            }
            lock.readLock().lock();
            
            Random rand = new Random();
            int n = rand.nextInt(9); 
            
               try {
                File archivo=new File("src//texto.txt");
                FileWriter escribir=new FileWriter(archivo,true);
                escribir.write(datos[n]);
                escribir.close();
            } catch (IOException ex) {
               
            }
        }
}
