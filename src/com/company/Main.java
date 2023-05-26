package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


    //Gets players name
    Scanner myObj = new Scanner(System.in);
    System.out.print("What is your name Player 1? - ");
    String player1 = myObj.nextLine();

    System.out.print("What is your name Player 2? - ");
    String player2 = myObj.nextLine();

    //Prints players name
    System.out.println("Player 1: " + player1);
    System.out.println("Player 2: " + player2);



    //Loop for whole game
    boolean gameQuit = true;
    while(gameQuit) {

        //Creates 3x3 board
        String[][] board = new String[3][3];

        //Fills the board with dashes "-"
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = "-";
            }
        }

        //boolean to keep track of players turn
        boolean player1Turn = true;

        //boolean loop if game ends
        boolean gameEnds = true;
        while (gameEnds) {

            //draws the 3x3 board
            drawBoard(board);

            //checking whose turn it is
            if (player1Turn) {
                System.out.println(player1 + "'s turn (X): ");
            } else {
                System.out.println(player2 + "'s turn (O): ");
            }

            //Setting up players character
            String c;
            if (player1Turn) {
                c = "X";
            } else {
                c = "O";
            }

            //variables for row/col
            int row = 0;
            int col = 0;

            //loop for players turn
            boolean playersTurnLoop = true;
            while (playersTurnLoop) {

                //getting players inputs for board
                System.out.print("Enter a row number (0, 1, 2): ");
                row = Integer.parseInt(myObj.nextLine());

                System.out.print("Enter a column number (0, 1, 2): ");
                col = Integer.parseInt(myObj.nextLine());

                //checks if players inputs are off the board/already taken/valid
                if (row > 2 || col > 2 || row < 0 || col < 0) {
                    System.out.println("That position is off the board. Try again.");
                } else if (!board[row][col].equals("-")) {
                    System.out.println("That spot has already been taken. Try again.");
                }
                //breaks out of loop if valid input
                else {
                    playersTurnLoop = false;
                }

            }

            //puts players input on board
            board[row][col] = c;

            //checking if either player has won
            if (playerWon(board).equals("X")) {
                drawBoard(board);
                System.out.println(player1 + " has won!");
                gameEnds = false;

            }
            else if (playerWon(board).equals("O")) {
                drawBoard(board);
                System.out.println(player2 + " has won!");
                gameEnds = false;
            }

            //checks if board is full/tie
            if (boardIsFull(board)) {
                drawBoard(board);
                System.out.println("The game is a tie!");
                gameEnds = false;
            }

            //switches players turn
            player1Turn = !player1Turn;

        }

        //asking user to keep playing
        System.out.print("Do you want to keep playing? y/n - ");
        String keepPlaying = myObj.nextLine();

        //conditional for users inputs
        if(keepPlaying.equals("y")){
            System.out.println("|NEW GAME|");
        }
        else if(keepPlaying.equals("n")){
            System.out.println("Thanks for playing!");
            gameQuit = false;
        }


    }





//end of Main
    }

    //function to check if board is full
    public static boolean boardIsFull(String[][] board){
        for(int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if(board[r][c].equals("-")){
                    return false;
                }

            }
        }
        return true;
    }


    //function to check if either player has won
    public static String playerWon(String[][] board){
        //checking rows
        for(int r = 0; r < board.length; r++){
            if(board[r][0].equals(board[r][1]) && board[r][1].equals(board[r][2])){
                return board[r][0];
            }
        }

        //checking columns
        for(int c = 0; c < board[0].length; c++){
            if(board[0][c].equals(board[1][c]) && board[1][c].equals(board[2][c])){
                return board[0][c];
            }
        }

        //checking diagonals
        if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])){
            return board[0][0];
        }
        if(board[2][0].equals(board[1][1]) & board[1][1].equals(board[0][2])){
            return board[2][0];
        }


        return "";
    }


    //function to draw the board
    public static void drawBoard(String[][] board){
        for(int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                System.out.print(board[r][c]);
            }
            System.out.println();
        }
    }






}

