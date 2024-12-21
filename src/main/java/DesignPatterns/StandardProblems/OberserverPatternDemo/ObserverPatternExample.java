package DesignPatterns.StandardProblems.OberserverPatternDemo;


public class ObserverPatternExample {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();

        ConcreteObserver concreteObserver1 = new ConcreteObserver();
        ConcreteObserver concreteObserver2 = new ConcreteObserver();

        concreteSubject.registerObserver(concreteObserver2);
        concreteSubject.registerObserver(concreteObserver1);
        concreteSubject.notifyObservers();

        concreteSubject.removeObserver(concreteObserver1);
        concreteSubject.notifyObservers();
    }
}
