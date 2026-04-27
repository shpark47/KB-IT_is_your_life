package main.java.ch04_inheritance_polymorphism.basic.ch07.advanced.exam;

public class LoginServlet extends HttpServlet {
    @Override
    public void service() {
        System.out.println("로그인 합니다.");
    }
}
