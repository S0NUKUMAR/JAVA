package DesignPatterns.StandardProblems.CommandPatternDemo;

public class CommandPatternExample {
    public static void main(String[] args) {
        ElectronicDevice TV = new Television();
        TelevisionON onCommand = new TelevisionON(TV);

        RemoteControl remoteControl = new RemoteControl(onCommand);
        remoteControl.press();
    }
}
