package com.bridgelabz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        description = "Login servlet testing",
        urlPatterns = ("/validateRegServlet"),
        initParams = {
                @WebInitParam(name = "user", value = ""),
                @WebInitParam(name = "mobile", value = ""),
                @WebInitParam(name = "pwd", value = ""),
                @WebInitParam(name = "address", value = ""),
        }
)
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        String mobile = req.getParameter("mobile");
        String address = req.getParameter("address");

        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        session.setAttribute("pwd", pwd);
        req.getRequestDispatcher("RegistrationSuccess.jsp").forward(req, res);

    }
}
