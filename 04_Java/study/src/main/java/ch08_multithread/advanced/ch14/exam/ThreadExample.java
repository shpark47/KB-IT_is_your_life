package main.java.ch08_multithread.advanced.ch14.exam;

public class ThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MovieThread());
        Thread t2 = new Thread(new MusicRunnable());

        t1.start();
        t2.start();
    }
}
