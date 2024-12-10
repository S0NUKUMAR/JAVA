package javalearning.multithreading;

class Consumer extends Thread {
    public void run() {
        System.out.println("Consumer");
    }
}

class Producer extends Thread {
    public void run() {
        synchronized (this){
            System.out.println("Producer");
            this.notify();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        synchronized (producer){
            consumer.start();
            try {
                producer.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Hello World");
        }

    }
}
