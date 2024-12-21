package javalearning.multithreading;
//create race condition


class Mythread extends Thread{
    static int count = 0;
    static Object lock = new Object();
    public synchronized void run(){
        synchronized (lock){
            for(int i = 0; i < 100000; i++) {
                if(Thread.currentThread().getName().equals("Thread 1"))
                    count++;
                else
                    count--;
            }
        }
    }
}

public class Synchronization {
    public static void main(String[] args) {
        Mythread t1 = new Mythread();
        t1.setName("Thread 1");
        t1.start();


        Mythread t2 = new Mythread();
        t2.setName("Thread 2");
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("this is main " + Mythread.count);
    }
}
