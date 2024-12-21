package javalearning.multithreading.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

class Display {
    private final ReentrantLock lock = new ReentrantLock();

    public void wish(String name) {
        lock.lock();
        try {
            for(int i = 0; i < 10; i++) {
                System.out.print("Hello ");
                Thread.sleep(200);
                System.out.println(name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class MyThread extends Thread {
    Display d;
    String name;

    MyThread(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.wish(name);
    }
}
public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        MyThread thread1 = new MyThread(display, "Alice");
        MyThread thread2 = new MyThread(display, "Bob");


        Thread thread = new Thread(() -> {
            display.wish("Alice");
        });
        thread.start();


        thread1.start();
        thread2.start();
    }
}
