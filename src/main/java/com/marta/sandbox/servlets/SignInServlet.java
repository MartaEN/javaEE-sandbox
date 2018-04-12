package com.marta.sandbox.servlets;

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
        req.getRequestDispatcher("signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String username = req.getParameter("username");

        Cookie user = new Cookie ( "username" , username);
        user.setHttpOnly(true);
        user.setMaxAge(60 * 60 * 24 * 365);
        resp.addCookie(user);

        req.setAttribute("auth-link","sign-out");
        req.setAttribute("auth-text", "Выйти");
        req.setAttribute("username", username);
        req.setAttribute("user-info", "Выполнен вход под именем " + username);
        req.setAttribute("message", "Signed in");

        req.getRequestDispatcher("/main").forward(req, resp);
    }
}
