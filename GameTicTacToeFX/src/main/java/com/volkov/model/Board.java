package com.volkov.model;


import com.volkov.players.Player;


public class Board {
    public static final int BOARD_SIZE = 3;
    private char[][] board;

    Player playerFirst;
    Player playerSecond;

    Player currentPlayer;

    Player winner;
    Winner lookForWinner;
    ValidateMove valid;

    public Board(Player playerFirst, Player playerSecond) {
        this.playerFirst = playerFirst;
        this.playerSecond = playerSecond;

        this.currentPlayer = playerFirst;

        board = new char[BOARD_SIZE][BOARD_SIZE];
        fillBoard();
    }






    public boolean gameFinished() {
        //todo finish the function
        boolean check = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    check = false;
                }
            }
        }
        if (winner != null) {
            return true;
        }
        return check;
    }

    public void fillBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }


    public Player getWinner() {
        return winner;
    }

    public char[][] getBoard() {
        return board;
    }
}