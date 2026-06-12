package org.edu.el;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/el/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        String passwd = req.getParameter("passwd");

        // 전달 받은 값 attribute에 세팅
        req.setAttribute("userId", userid);
        req.setAttribute("pwd", passwd);

        req.getRequestDispatcher("/el/login.jsp").forward(req, resp);
    }
}
