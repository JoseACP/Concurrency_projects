/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

/**
 *
 * @author x1
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Prueba {
 
    public static void main(String[] args) {
 
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("Thread 1: Hi!");
                    try {
                        wait();
                        System.out.println("Thread 1: How are you?");
                        wait();
                        System.out.println("Thread 1: Bye!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
 
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("Thread 2: Hi there!");
                    notify();
                    try {
                        wait();
                        System.out.println("Thread 2: I'm doing great!");
                        notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
 
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("Thread 3: Hi guys!");
                    notify();
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
 
        thread1.start();
        thread2.start();
        thread3.start();
        
    }
    
}
     

