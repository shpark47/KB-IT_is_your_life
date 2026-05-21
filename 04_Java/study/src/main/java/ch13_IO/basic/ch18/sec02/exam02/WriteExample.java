package main.java.ch13_IO.basic.ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExample {
    public static void main(String[] args) {
        byte[] array = { 10, 20, 30 };

        try(FileOutputStream fos = new FileOutputStream("study/src/main/java/ch13_IO/basic/temp/test2.db")) {
            fos.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
