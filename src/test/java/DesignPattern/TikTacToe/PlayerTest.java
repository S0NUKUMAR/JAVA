package DesignPattern.TikTacToe;

import DesignPatterns.TikTacToe.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void PlayerInit(){
        Player result = new Player(1 , "one");
        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("one", result.getName());
    }
}
