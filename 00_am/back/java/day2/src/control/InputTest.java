package control;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {
        System.out.println("모니터에 입력");

        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        System.out.println(data);

        String data2 = sc.nextLine();
        System.out.println(data2 + 1);
    }
}
