package main.java.ch04_inheritance_polymorphism.basic.ch07.advanced.exam;

public class HttpServletExample {
    public static void main(String[] args) {
        method(new LoginServlet());     // 로그인합니다.
        method(new FileDownloadServlet()); // 파일다운로드합니다.
    }

    public static void method(HttpServlet servlet) {
        servlet.service();
    }
}
