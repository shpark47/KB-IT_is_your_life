package org.scoula.ex04.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class RequestLogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("RequestLogFilter 필터 초기화");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        System.out.println("2.-------------------");

        // ServletRequest를 HttpServletRequest로 형변환
        HttpServletRequest req = (HttpServletRequest) request;

        // 요청 URI 출력
        String uri = req.getRequestURI();
        System.out.println("[요청 URL] " + uri + ": " + req.getParameter("addr"));

        // 다음 필터 또는 서블릿으로 이동
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("RequestLogFilter 종료");
    }
}