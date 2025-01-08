package DesignPatterns.StandardProblems.AdaptorPatternDemo;

public class EnemyRobotAdaptor implements EnemyAttacker {
    EnemyRobot robot ;

    public EnemyRobotAdaptor(EnemyRobot robot) {
        this.robot = robot;
    }

    @Override
    public void fireWeapon() {
        this.robot.smashWithHand();
    }

    @Override
    public void driveForward() {
        this.robot.walkForward();
    }

    @Override
    public void assignDriver(String name) {
        this.robot.reactToHuman(name);
    }
}
