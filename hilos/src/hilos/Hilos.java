/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilos;

/**
 *
 * @author x1
 */
public class Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            for(int i = 0; i<=5; i++){
            System.out.println("Proceso 1"); 
        }
        
        System.out.println("");
        
        for(int i = 0; i<=5; i++){
            System.out.println("Proceso 2"); 
        }
    }
    
}
