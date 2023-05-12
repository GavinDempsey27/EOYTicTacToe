package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    //Creates 3x3 board
    String[][] board = new String[3][3];

    //Fills the board with dashes "-"
    for(int r = 0; r < board.length; r++){
        for(int c = 0; c < board[r].length; c++){
            board[r][c] = "-";
        }
    }

    //Gets players name
    Scanner myObj = new Scanner(System.in);
    System.out.print("What is your name Player 1? - ");
    String player1 = myObj.nextLine();

    System.out.print("What is your name Player 2? - ");
    String player2 = myObj.nextLine();

    //Prints players name
    System.out.println("Player 1: " + player1);
    System.out.println("Player 2: " + player2);

    drawBoard(board);


    }

    public static void drawBoard(String[][] board){
        for(int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {

            }
        }
    }




}

