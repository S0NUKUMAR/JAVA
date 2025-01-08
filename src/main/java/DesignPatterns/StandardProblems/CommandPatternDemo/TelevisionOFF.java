package DesignPatterns.StandardProblems.CommandPatternDemo;

public class TelevisionOFF implements Command{
    ElectronicDevice  electronicDevice;

    public TelevisionOFF(ElectronicDevice electronicDevice){
        this.electronicDevice = electronicDevice;
    }
    @Override
    public void execute() {
        this.electronicDevice.off();
    }
}
