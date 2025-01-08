package DesignPatterns.StandardProblems.CommandPatternDemo;

public class TelevisionON implements Command{
    ElectronicDevice  electronicDevice;

    public TelevisionON(ElectronicDevice electronicDevice){
        this.electronicDevice = electronicDevice;
    }
    @Override
    public void execute() {
        this.electronicDevice.on();
    }
}
