package DesignPatterns.TicTacToe;

import java.util.Scanner;

public class Game {
    private final Player playerA;
    private final Player playerB;
    private Player currentPlayer;
    private final Board board;

    Game(Player pA, Player pB) {
        playerA = pA;
        playerB = pB;
        this.board = new Board();
        currentPlayer = pA;
    }

    public void play() {
        while (!this.board.isFull() && !this.board.isWinner()) {
            System.out.println(this.currentPlayer.getName() + "'s Turn");
            int row = getValuesFromPlayer("Enter row Value between 0-2 :");
            int col = getValuesFromPlayer("Enter col Value between 0-2 :");
            try {
                board.makeMove(row, col, currentPlayer.getSymbol());
                board.printBoard();
                switchPlayer();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (board.isWinner()) {
                switchPlayer();
                System.out.println(currentPlayer.getName() + " wins!");
            } else {
                System.out.println("It's a draw!");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerA) ? playerB : playerA;
    }

    private int getValuesFromPlayer(String s) {
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            System.out.print(s);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0 && input <= 2) {
                    return input;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input! Please enter a number between 0 and 2.");
        }
    }
}
