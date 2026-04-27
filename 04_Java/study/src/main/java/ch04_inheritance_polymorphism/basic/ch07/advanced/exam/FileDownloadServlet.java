package main.java.ch04_inheritance_polymorphism.basic.ch07.advanced.exam;

public class FileDownloadServlet extends HttpServlet {
    @Override
    public void service() {
        System.out.println("다운로드 합니다.");
    }
}
