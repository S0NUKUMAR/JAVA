package DesignPatterns.StandardProblems.CommandPatternDemo;

public class Television implements ElectronicDevice{
    private int volume = 0;
    @Override
    public void on() {
        System.out.println("TV is ON");
    }

    @Override
    public void off() {
        System.out.println("TV is Off");
    }

    @Override
    public void volumeUp() {
        System.out.println("Turning Volume UP " + ++volume);
    }

    @Override
    public void volumeDown() {
        System.out.println("Turning Volume Down " + --volume);
    }
}
