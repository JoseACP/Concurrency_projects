
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
public class clase {
    public static void main(String[] args) {
        
        
    //esta es la sintaxis para crear un objeto con extends Threads
        proceso2 hilo2 = new proceso2();
        
    //Para utilizar Runnable necesitamos la siguiente sintaxis.
        //Thread hilo1 = new Thread(new proceso1());
        
    //Recuerda que primero se deben crear todos los objetos y despues arrancarlos
        //hilo1.start();
        hilo2.start();
        hilo2.start();
        hilo2.start();
        hilo2.start();
        
    }
}
