package main.java.ch13_IO.basic.ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExample {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        byte c = 30;

        try(FileOutputStream fos = new FileOutputStream("study/src/main/java/ch13_IO/basic/temp/test1.db")) {
            fos.write(a);
            fos.write(b);
            fos.write(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
