package DesignPatterns.StandardProblems.OberserverPatternDemo;


public class ConcreteObserver implements Observer {
        @Override
        public void update() {
            System.out.println("Observer is updated" + this.toString());
        }
}
