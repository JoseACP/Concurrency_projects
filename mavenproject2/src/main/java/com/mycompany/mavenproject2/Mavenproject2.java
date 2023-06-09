/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

/**
 *
 * @author x1
 */
public class Mavenproject2 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
import java.util.ArrayList;

public class WordSearch {

    static char[][] board;
    static int board_x, board_y;
    static ArrayList <String> search_words;

    public static void main(String args[])
    {
        board = new char[][]{
            { 's', 't', 'a', 'c', 'k' },
            { 'x', 'f', 'l', 'o', 'w' },
            { 'x', 'x', 'x', 'v', 'x' },
            { 'x', 'x', 'x', 'e', 'x' },
            { 'x', 'x', 'x', 'r', 'x' },
        };
        // You could also get these from board.size, etc
        board_x = 5;    
        board_y = 5;

        search_words = new ArrayList<String>();
        search_words.add("stack");
        search_words.add("over");
        search_words.add("flow");
        search_words.add("not");

        for(String word : search_words){
            find(word);
        }
    }

    public static void find(String word)
    {
        // Search for the word laid out horizontally
        for(int r=0; r<board_y; r++){
            for(int c=0; c<=(board_x - word.length()); c++){
                // The pair (r,c) will always be where we start checking from
                boolean match = true;
                for(int i=0; i<word.length(); i++){
                    if(board[r][c + i] != word.charAt(i)){
                        match = false;
                        System.out.format("    '%s' not found starting at (%d,%d) -- first failure at %d\n", word, r, c, i);
                        break;
                    }
                }

                if(match){
                    System.out.format("Found match (horizontal) for '%s' starting at (%d,%d)\n", word, r, c);
                }
            }
        }
    }
}