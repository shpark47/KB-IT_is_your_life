package main.java.ch12_stream.basic.ch17.sec04.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        String[] strArray = {"홍길동", "신용권", "김미나"};
        Stream<String> stream = Arrays.stream(strArray);
        stream.forEach(s -> System.out.print(s + ","));

        System.out.println();

        int[] intArray = {1, 2, 3, 4, 5};
        IntStream stream2 = Arrays.stream(intArray);
        stream2.forEach(i -> System.out.print(i + ","));
    }
}
