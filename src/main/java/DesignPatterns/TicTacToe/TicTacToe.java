package DesignPatterns.TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {
        Player one = new Player('X', "one");
        Player two = new Player('0', "two");

        Game game = new Game(one , two);
        game.play();
    }
}
