package com.bridgelabz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login servlet testing",
        urlPatterns = ("/loginServlet")

)

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");

        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("user");

        HttpSession session1 = req.getSession();
        String password = (String) session1.getAttribute("pwd");

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
