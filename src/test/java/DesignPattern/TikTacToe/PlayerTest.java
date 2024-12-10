package DesignPattern.TikTacToe;

import DesignPatterns.TicTacToe.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void PlayerInit(){
        Player result = new Player( 'X', "one");
        Assertions.assertEquals('X', result.getSymbol());
        Assertions.assertEquals("one", result.getName());
    }
}
