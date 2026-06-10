package org.scoula.ai;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

public class PerformanceMonitorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // 1. 요청 접수 시간 및 시작 시간(ms) 기록
        LocalDateTime requestTime = LocalDateTime.now();
        long startTime = System.currentTimeMillis();

        // 다음 필터 또는 서블릿으로 요청 전달
        chain.doFilter(request, response);

        // 2. 처리 완료 후 종료 시간(ms) 기록 및 수행 시간 계산
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        // 3. System.out을 이용해 터미널에 로그 출력
        String requestUrl = httpRequest.getRequestURI();
        System.out.println("[" + requestTime + "] " + requestUrl + " - " + duration + "ms 소요.");
    }

    @Override
    public void destroy() {
    }
}