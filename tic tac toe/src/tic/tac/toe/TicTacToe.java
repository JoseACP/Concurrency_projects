/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tic.tac.toe;

// A simple program to demonstrate
// Tic-Tac-Toe Game.
import java.util.*;


public class TicTacToe extends Thread {
    
static  char[][] map = new char[3][3];
static char notsCrosses;
static volatile boolean gameFinish = false;


public TicTacToe(String n){
    super(n);
}
public TicTacToe(){

}
public synchronized String pickPosition(int x){

    switch (x){
        case 1: map[0][0] = notsCrosses; return "00";
        case 2: map[0][1] = notsCrosses; return "01";
        case 3: map[0][2] = notsCrosses; return "02";
        case 4: map[1][0] = notsCrosses; return "10";
        case 5: map[1][1] = notsCrosses; return "11";
        case 6: map[1][2] = notsCrosses; return "12";
        case 7: map[2][0] = notsCrosses; return "20";
        case 8: map[2][1] = notsCrosses; return "21";
        case 9: map[2][2] = notsCrosses; return "22";
    }
    return null;
}

public void run() {
    if (this.getName() == "player1") {
        notsCrosses = 'X';
    } else {
        notsCrosses = 'O';
    }
    Scanner input = new Scanner(System.in);
    synchronized (this) {
        while (!gameFinish) {
            try {
                System.out.print(this.getName() + " Enter the position (1-9): ");
                int position = input.nextInt();
                pickPosition(position);

                System.out.print("h");
                printMaze();
                int yCood = Integer.parseInt(pickPosition(position).substring(0, 1));
                int xCood = Integer.parseInt(pickPosition(position).substring(1, 2));

                if (hasWon(map, xCood, yCood)) {
                    System.out.println("You win! " + this.getName());
                    gameFinish = true;
                }

                notify();
                wait();
            } catch (InterruptedException i) {

            }
        }
    }
}


public static void main(String[] args) {
    for(int i=0; i<map.length; i++){
        for(int j=0; j<map[i].length; j++){
            map[i][j] = '-';
        }

    }
    new TicTacToe().printMaze();

    TicTacToe player1 = new TicTacToe("player1");
    TicTacToe player2 = new TicTacToe("player2");

    player1.start();
    player2.start();

}
public synchronized void printMaze(){
        for(int i=0; i<map.length; i++){
            if(i==0) {
                for (int x = 0; x < 3; x++) {
                    System.out.print("---");
                }
                System.out.println();
            }
            for(int j=0; j<map[i].length; j++) {
                System.out.print("|");
                System.out.print(map[i][j]);
                System.out.print("|");
            }
            System.out.println();
            for(int x=0; x<3; x++) {
                System.out.print("---");
            }
            System.out.println();

        }

}


public synchronized boolean hasWon(char[][] m,int xCood, int yCood){
    if(checkRow(m,yCood) || checkColumn(m,xCood) || checkDiagonal(m,xCood,yCood)){
        return true;
    }
    return false;


}

public synchronized boolean checkRow(char[][] m,int yCood){
    for(int i=0; i<3; i++){
        if(map[yCood][i] != notsCrosses){
            return false;
        }
    }
    return true;
}

public synchronized boolean checkColumn(char[][] m,int xCood){
    for(int i=0; i<3; i++){
        if(map[i][xCood] != notsCrosses){
            return false;
        }
    }
    return true;
}
public synchronized boolean checkDiagonal(char[][] m,int xCood, int yCood){
    if(map[0][0]==notsCrosses && map[1][1]==notsCrosses && map[2][2]==notsCrosses){
            return true;
    }
    else if(map[2][0]==notsCrosses && map[1][1]==notsCrosses && map[0][2]==notsCrosses){
            return true;
    }
    return false;


}
}
