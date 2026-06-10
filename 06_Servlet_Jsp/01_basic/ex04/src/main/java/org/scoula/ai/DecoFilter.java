package org.scoula.ai;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class DecoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestUrl = httpRequest.getRequestURI();

        // 1. 요청 처리 전 출력
        System.out.println(requestUrl + " =======>");

        // 다음 필터 또는 서블릿으로 요청 전달
        chain.doFilter(request, response);

        // 2. 요청 처리 후 출력
        System.out.println("<=======");
    }

    @Override
    public void destroy() {
    }
}