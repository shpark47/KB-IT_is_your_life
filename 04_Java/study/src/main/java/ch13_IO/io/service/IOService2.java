package main.java.ch13_IO.io.service;

import java.io.*;

public class IOService2 {
    // try-with-resources
    // -> try() 안에서 생성한 스트림 객체는 try 종료 시 자동으로 close() 수행

    // 실행 순서
    // try 실행 -> catch (예외 발생 시) -> 자동 close() -> finally 실행

    // 바이트 기반 파일 출력
    public void byteOutput() {
        try(FileOutputStream fos = new FileOutputStream("study/src/main/java/ch13_IO/io/byte/byteTest.txt", true)) {
            // 현재 프로그램에서 해당 경로에 byteTest.txt 파일로 출력하는 통로 객체 생성

            String content = "Hello";

            for (int i = 0; i < content.length(); i++) {
//                System.out.println(content.charAt(i));
                fos.write(content.charAt(i));
            }
        } catch (IOException e) {
            // IO와 관련된 코드는 IOException을 발생 시킬 가능성이 높음

            System.out.println("예외 발생");
            e.printStackTrace();
        }
    }

    // 문자 기반 파일 출력
    public void charOutput() {
        try(FileWriter fw = new FileWriter("study/src/main/java/ch13_IO/io/char/charTest.txt")) {
            // char 폴더에 charTest.txt가 있으면 문자 출력 스트림 연결
            // 만약 파일이 없다면 해당 경로에 파일을 만들어서 연결

            String content = "곧 조 발표 합니다 ^-^";

            fw.write(content); // 문자열을 통째로 내보낸다.
            // 한 줄을 통째로 내보내기 위해 "버퍼"를 이용하는데
            // 아직 버퍼에 담겨 있음!

            // 버퍼에 남아있는 내용 강제로 출력
            fw.flush();

            // close() 구문을 실행하면 통로에 남아있는 내용을
            // 모두 내보내고 통로를 없앤다.

            System.out.println("출력 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 바이트 기반 파일 입력
    public void byteInput() {
        // 파일 -> 프로그램으로 읽어오는 바이트 기반 스트림
        try(FileInputStream fis = new FileInputStream("study/src/main/java/ch13_IO/io/byte/byteTest.txt")) {
            while (true) {
                int data = fis.read(); // 다음 1byte를 읽어오는데 정수형임
                                       // 다음 내용이 없으면 -1 반환
                if(data == -1) break;

                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 문자 기반 파일 입력
    public void charInput() {
        try(FileReader fr = new FileReader("study/src/main/java/ch13_IO/io/char/charTest.txt")) {
            while (true) {
                int data = fr.read();
                if (data == -1) break;

                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
