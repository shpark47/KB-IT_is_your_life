package main.java.ch13_IO.basic.ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExample {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("study/src/main/java/ch13_IO/basic/temp/test1.db")) {
            while (true) {
                int data = fis.read();
                if (data == -1) break;
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
