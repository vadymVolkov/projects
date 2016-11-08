package com.volkov.model;

public class ValidateMove {
    public boolean validateMove(String move, char[][] board) {
        int i, j;
        if (move.length() == 2) {
            i = move.charAt(0) - 48;
            j = move.charAt(1) - 48;
        } else {
            System.out.println("Wrong move, try again");
            return false;
        }
        if (j > 2 || j < 0 || i > 2 || i < 0) {
            System.out.println("Wrong move, try again");
            return false;
        }
        if (board[i][j] == ' ') {
            return true;
        } else {
            System.out.println("Wrong move, try again");
            return false;
        }
    }
}