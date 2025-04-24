package ticTacToe;

public class MainTicTacToe {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        PlayerThread player1 = new PlayerThread("1-й поток", 'X', game);
        PlayerThread player2 = new PlayerThread("2-й поток", 'O', game);

        player1.start();
        player2.start();

        try {
            player1.join();
            player2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("1-й поток закончил!");
        System.out.println("2-й поток закончил!");

        String winner = game.getWinner();
        if (winner != null) {
            System.out.println("Победил: " + winner);
        } else {
            System.out.println("Ничья!");
        }
    }
}