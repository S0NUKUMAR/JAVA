package javalearning.multithreading;

class ExtendThread extends Thread{
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("this is thread using Thread class");
    }
}

public class JavaThread {
    public static void main(String[] args) {
        ExtendThread t1 = new ExtendThread();
        t1.start();

        Runnable r2 = () -> {
            System.out.println("this the runnable 2 using the lambda expression");
        };
        Thread thr = new Thread(r2);

        thr.start();
        System.out.println("this is main");
    }
};
