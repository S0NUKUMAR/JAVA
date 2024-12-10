package javalearning.others;

public class Test {
    public static void main(String[] args) {
        Thread one = new Thread(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("this is the demo running on the thread one ");
        });
        one.setDaemon(true);
        one.start();
        System.out.println("this it the main class running");
        try {
            one.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
