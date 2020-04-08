package com.bridgelabz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login servlet testing",
        urlPatterns=("/loginServlet"),
        initParams={
@WebInitParam(name = "user", value = "Palak"),
@WebInitParam(name = "pwd", value = "plk")
        }
)

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        String userId = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("pwd");

        if (userId.equals(user) && (password.equals(pwd))) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, res);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = res.getWriter();
            out.println("<font color=red> user name or pwd is wrong.</font>");
            rd.include(req, res);
        }
    }
}
