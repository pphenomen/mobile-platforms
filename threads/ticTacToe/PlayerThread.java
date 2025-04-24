package ticTacToe;

public class PlayerThread extends Thread {
    private final String name;
    private final char symbol;
    private final TicTacToeGame game;

    public PlayerThread(String name, char symbol, TicTacToeGame game) {
        this.name = name;
        this.symbol = symbol;
        this.game = game;
    }

    @Override
    public void run() {
        while (game.makeMove(name, symbol)) {
            try {
                Thread.sleep(300); // задержка между ходами
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}