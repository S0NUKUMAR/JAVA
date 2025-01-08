package DesignPatterns.StandardProblems.AdaptorPatternDemo;

import java.util.Random;

public class EnemyTank implements EnemyAttacker{
    Random random = new Random();
    @Override
    public void fireWeapon() {
        int attackDamage = random.nextInt(5) + 1;
        System.out.println("Enemy Tank does " + attackDamage + " Damage");
    }

    @Override
    public void driveForward() {
        int moves = random.nextInt(4) + 1;
        System.out.println("Enemy Tank moves " + moves + " distance ");
    }

    @Override
    public void assignDriver(String name) {
        System.out.printf("%s is driving the Tank", name);
    }
}
