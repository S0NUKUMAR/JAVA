package DesignPatterns;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class ConcreteSubject implements Subject {
    private final List<Observer> observers;

    public ConcreteSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}

class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("Observer is updated" + this.toString());
    }
}

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
