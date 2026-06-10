package org.scoula.ai;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deco/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 서블릿이 실행되었음을 확인하기 위한 콘솔 출력
        System.out.println("===> [Servlet] 실제 서블릿 로직 수행 중...");

        // 브라우저 화면 출력
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<h1>Deco 필터 및 성능 모니터링 필터 테스트 페이지</h1>");
        out.print("</body></html>");
    }
}