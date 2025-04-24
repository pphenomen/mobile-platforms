package ticTacToe;

import java.util.Arrays;

public class TicTacToeGame {
    private final char[][] board = new char[3][3];
    private char winner = ' ';
    private boolean gameOver = false;
    private char currentPlayer = 'X';

    public TicTacToeGame() {
        for (char[] row : board) {
            Arrays.fill(row, '-');
        }
    }

    public synchronized boolean makeMove(String playerName, char symbol) {
        while (symbol != currentPlayer && !gameOver) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (gameOver) return false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = symbol;
                    System.out.println(playerName + " поставил " + symbol + " на " + i + "," + j);
                    printBoard();
                    if (checkWin(symbol)) {
                        winner = symbol;
                        gameOver = true;
                    } else if (isBoardFull()) {
                        gameOver = true;
                    }
                    currentPlayer = (symbol == 'X') ? 'O' : 'X';
                    notifyAll();
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == '-') return false;
        return true;
    }

    private boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;
        return false;
    }

    public String getWinner() {
        if (winner == 'X') return "1-й поток";
        if (winner == 'O') return "2-й поток";
        return null;
    }

    private void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

