package main.java.ch08_multithread.thread.ex2;

public class SleepThreadRun {
    public static void main(String[] args) {
        Thread thread = new Thread(new SleepThread());
        thread.start();
        // -> SleepThread의 run() 메서드 실행
    }
}
