package DesignPatterns.StandardProblems.BuilderPatternDemo;

public class Computer {
    private String HDD;
    private String RAM;

    private boolean isGraphicCardEnabled;
    private boolean isBlutoothEnabled;

    public Computer(ComputerBuilder builder){
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicCardEnabled = builder.isGraphicCardEnabled;
        this.isBlutoothEnabled = builder.isBlutoothEnabled;
    }

    public String toString(){
        return this.RAM + " " + this.HDD + " " + this.isBlutoothEnabled + " " + this.isGraphicCardEnabled;
    }

    public static class ComputerBuilder {
        private String HDD;
        private String RAM;

        private boolean isGraphicCardEnabled;
        private boolean isBlutoothEnabled;

        public ComputerBuilder(String HDD , String RAM){
            this.HDD = HDD;
            this.RAM = RAM;
        }

        public ComputerBuilder setGraphicCardEnabled(boolean isGraphicCardEnabled){
            this.isGraphicCardEnabled = isGraphicCardEnabled;
            return this;
        }

        public ComputerBuilder setBlutoothEnabled(boolean isBlutoothEnabled){
            this.isBlutoothEnabled = isBlutoothEnabled;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}
