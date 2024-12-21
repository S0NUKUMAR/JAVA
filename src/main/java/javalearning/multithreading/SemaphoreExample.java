package javalearning.multithreading;

import java.util.concurrent.Semaphore;

class Job implements Runnable {
    int count = 0;
    Semaphore semaphore;
    Job(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    public  void  increment(){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int i = 0 ;
        while(i< 1000){
            this.count++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
        semaphore.release();
    }
    public void run(){
        this.increment();
    }

    public int getCount(){
        return this.count;
    }
}

public class SemaphoreExample {
    static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        System.out.println("semaphore Example ");

        Job j = new Job(semaphore);
        Thread t1 = new Thread(j);
        Thread t2 = new Thread(j);

        t1.start();
        t2.start();

        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(j.getCount());
    }
}
