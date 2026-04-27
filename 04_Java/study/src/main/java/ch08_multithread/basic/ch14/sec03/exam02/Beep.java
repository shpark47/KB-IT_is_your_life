package main.java.ch08_multithread.basic.ch14.sec03.exam02;

public class Beep implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println("beep");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
