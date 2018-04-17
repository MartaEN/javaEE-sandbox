package com.marta.sandbox.servlet;

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

        Cookie usernameCookie = new Cookie("username", null);
        usernameCookie.setMaxAge(0);
        resp.addCookie(usernameCookie);

        req.setAttribute("username", null);
        req.getSession().invalidate();

        resp.sendRedirect("home");

    }
}
