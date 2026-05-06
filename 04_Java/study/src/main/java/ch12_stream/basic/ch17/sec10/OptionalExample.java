package main.java.ch12_stream.basic.ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        System.out.println("평균: " + avg);
    }
}
