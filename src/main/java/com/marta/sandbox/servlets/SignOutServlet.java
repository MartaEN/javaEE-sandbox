package com.marta.sandbox.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-out")
public class SignOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie [] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals("username")) {
                cookies[i].setMaxAge(0);
                resp.addCookie(cookies[i]);
            }
        }

        req.setAttribute("auth-link","sign-in");
        req.setAttribute("auth-text", "Войти");
        req.setAttribute("username", null);
        req.setAttribute("user-info", "Пользователь не авторизован");
        req.setAttribute("message", "Signed out");

        req.getRequestDispatcher("/main").forward(req, resp);
    }
}
