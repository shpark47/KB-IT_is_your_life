package main.java.ch08_multithread.basic.ch14.sec03.exam02;

public class BeepPrintExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Beep());
        thread.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println("띵");
            } catch (InterruptedException e) {}
        }
    }
}
