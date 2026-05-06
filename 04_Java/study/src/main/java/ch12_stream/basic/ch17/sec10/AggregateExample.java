package main.java.ch12_stream.basic.ch17.sec10;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AggregateExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // 2의 배수 카운팅
        System.out.println("2의 배수 개수 : " + Arrays.stream(arr).filter(i -> i % 2 == 0).count());

        // 2의 배수 총합
        System.out.println("2의 배수의 합 : " + Arrays.stream(arr).filter(i -> i % 2 == 0).sum());

        // 2의 배수 평균
        System.out.println("2의 배수의 평균 : " + Arrays.stream(arr).filter(i -> i % 2 == 0).average().getAsDouble());

        // 2의 배수 중 최대값
        System.out.println("최대값 : " + Arrays.stream(arr).filter(i -> i % 2 == 0).max().getAsInt());

        // 2의 배수 중 최소값
        System.out.println("최소값 : " + Arrays.stream(arr).filter(i -> i % 2 == 0).min().getAsInt());

        // 첫 번째 3의 배수
        System.out.println("첫 번째 3의 배수 : " + Arrays.stream(arr).filter(i -> i % 3 == 0).findFirst().getAsInt());
    }
}
