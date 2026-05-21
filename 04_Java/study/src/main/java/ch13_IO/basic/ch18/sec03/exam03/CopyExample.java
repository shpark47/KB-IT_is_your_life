package main.java.ch13_IO.basic.ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyExample {
    public static void main(String[] args) {
        String originalFileName = "study/src/main/java/ch13_IO/basic/temp/test.jpg";
        String targetFileName = "study/src/main/java/ch13_IO/basic/temp/test2.jpg";

        try(
                FileInputStream fis = new FileInputStream(originalFileName);
                FileOutputStream fos = new FileOutputStream(targetFileName);
        ) {
            byte[] data = new byte[1024];
            while (true) {
                int num = fis.read(data);
                if (num == -1) break;
                fos.write(data, 0, num);
            }
            fos.flush();
            System.out.println("복사 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
