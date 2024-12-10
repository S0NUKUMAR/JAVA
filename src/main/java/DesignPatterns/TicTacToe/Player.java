package DesignPatterns.TicTacToe;

public class Player {
    char symbol;
    String name;

    public Player(char symbol, String name){
        this.symbol = symbol;
        this.name = name;
    }

    public char getSymbol(){
        return this.symbol;
    }

    public String getName(){
        return name;
    }
}


