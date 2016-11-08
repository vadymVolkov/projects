package com.volkov.model;


import com.volkov.players.Player;

public class Winner {
    Player winner;

    public void search(char[][] board, Player playerFirst, Player playerSecond) {
        char firstPlayerSign = playerFirst.getType();
        char secondPlayerSign = playerSecond.getType();

        for (int i = 0; i < board.length; i++) {

            //Проверка побед по горизонталям
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == firstPlayerSign) {
                winner = playerFirst;
            } else if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == secondPlayerSign) {
                winner = playerSecond;
            }

            // Проверка побед по вертикалям
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] == firstPlayerSign) {
                winner = playerFirst;
            } else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] == secondPlayerSign) {
                winner = playerSecond;
            }

        }
        // Проверка побед по диогоналям №1
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == firstPlayerSign) {
            winner = playerFirst;
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == secondPlayerSign) {
            winner = playerSecond;
        }
        // Проверка побед по диогоналям №2
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == firstPlayerSign) {
            winner = playerFirst;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == secondPlayerSign) {
            winner = playerSecond;
        }
    }

    public Player getWinner() {
        return winner;
    }
}