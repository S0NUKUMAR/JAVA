package DesignPatterns.StandardProblems.AdaptorPatternDemo;

import java.util.Random;

public class EnemyRobot {
    Random random = new Random();

    public void smashWithHand(){
        int attack = random.nextInt(10) + 1;
        System.out.println("Robot attack Value " + attack);
    }

    public void walkForward(){
       int move = random.nextInt(4) + 1;
        System.out.println("Robot Moves distance : " + move);
    }

    public void reactToHuman(String name){
        System.out.println("Robot tramps on " + name);
    }
}
