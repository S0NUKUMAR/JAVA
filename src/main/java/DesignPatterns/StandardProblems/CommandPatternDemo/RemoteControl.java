package DesignPatterns.StandardProblems.CommandPatternDemo;

public class RemoteControl {
    Command command;

    public RemoteControl(Command command){
        this.command = command;
    }

    public void press(){
        this.command.execute();
    }
}
