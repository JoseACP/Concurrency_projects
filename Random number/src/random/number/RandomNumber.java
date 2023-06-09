/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package random.number;

/**
 *
 * @author x1
 */
import java.util.Random;
public class RandomNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random num = new Random();
        int res;
        for ( int i = 1; i <= 5; i++ ){
        res = 1 + num.nextInt(20);
         System.out.printf( "%d ", res );
        }
    }
    
}
