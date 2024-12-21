package javalearning.multithreading;

import java.lang.Runnable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter implements Runnable
{
    Lock lock = new ReentrantLock();
    private int c = 0;
    public void increment()
    {
        try
        {
            Thread.sleep(10);
        }
        catch (InterruptedException e)
        {
//Auto-generated catch block
            e.printStackTrace();
        }
        c++;
    }
    public void decrement()
    {
        c--;
    }
    public int getValue()
    {
        return c;
    }
    @Override
    public void run() {
//incrementing
//        lock.lock();
        try {
            this.increment();
            System.out.println("Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getValue());
//decrementing
            this.decrement();
            System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getValue());
        }finally {
//            lock.unlock();
        }
    }
}
public class Main
{

    public static void main(String args[])
    {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}