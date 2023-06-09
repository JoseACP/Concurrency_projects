/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package average;

/**
 *
 * @author x1
 */
public class Average {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here public static void main(String[] args) {
        int[][] matriz = { { 11, 1232, 386, 432 }, { 47, 454, 254, 353 } };

        int sumatoria = 0; // Aquí iremos sumando cada valor
        int cantidadDeElementos = 0; // Contar los elementos

        // Recorremos la matriz
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                int numeroActual = matriz[x][y];
                sumatoria = sumatoria + numeroActual;
                cantidadDeElementos = cantidadDeElementos + 1;
            }
        }
        float promedio = (float) sumatoria / cantidadDeElementos;
        System.out.printf("La sumatoria es %d y el promedio es %f", sumatoria, promedio);
    }
    }
    
