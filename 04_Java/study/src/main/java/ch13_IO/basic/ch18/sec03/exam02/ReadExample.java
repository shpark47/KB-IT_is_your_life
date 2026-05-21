package main.java.ch13_IO.basic.ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("study/src/main/java/ch13_IO/basic/temp/test2.db")) {
            byte[] data = new byte[100];
            while (true) {
                int num = fis.read(data);
                if (num == -1) break;
                for (int i = 0; i < num; i++) {
                    System.out.println(data[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
