package com.marta.sandbox.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-in")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String username = req.getParameter("username");

        Cookie user = new Cookie ( "username" , username);
        user.setHttpOnly(true);
        user.setMaxAge(60 * 60 * 24 );
        resp.addCookie(user);

        req.setAttribute("username", username);

        resp.sendRedirect("checkout");
    }
}
