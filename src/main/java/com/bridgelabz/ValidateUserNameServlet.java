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
        urlPatterns = ("/validateLoginServlet"),
        initParams = {
                @WebInitParam(name = "user", value = ""),
                @WebInitParam(name = "pwd", value = "")}
)

public class ValidateUserNameServlet extends HttpServlet {
    String REGEX_NAME = "[A-Z]{1}[A-Za-z]{2,}";
    String REGEX_PASSWORD = "^((?=[^\\W\\_]*[\\W\\_][^\\W\\_]*$)(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9\\W\\_]{8,})$";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");

        if (validateUserName(user) && validatePassword(pwd)) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, res);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = res.getWriter();
            out.println("<font color=red> user name or pwd is wrong.</font>");
            rd.include(req, res);
        }
    }

    public boolean validateUserName(String user) {
        return user.matches(REGEX_NAME);
    }

    public boolean validatePassword(String pwd) {
        return pwd.matches(REGEX_PASSWORD);
    }
}