package DesignPatterns.StandardProblems.BuilderPatternDemo;

public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer comp = new Computer
                .ComputerBuilder("500GB", "2GB")
                .setBlutoothEnabled(true)
                .setGraphicCardEnabled(true)
                .build();
        System.out.println(comp);
    }
}
