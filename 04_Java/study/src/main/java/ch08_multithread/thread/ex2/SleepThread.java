package main.java.ch08_multithread.thread.ex2;

public class SleepThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "실행");

        for (int i = 1; i <= 10; i++) {
            // Thread.sleep(long millis)
            // - 현재 스레드를 지정된 시간만큼 일시정지
            // - 시간은 1/1000초 단위(ms)로 지정
            // - InterruptedException 예외 처리 필요
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // 예외가 발생한 위치와 흐름을 출력
            }

            System.out.println(i + "초");
        }
    }
}
