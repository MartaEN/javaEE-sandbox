package com.marta.sandbox.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Корзина");
        req.setAttribute("link", "<a href=\"product\">Товар</a>");
        req.setAttribute("message", " ");
        req.getRequestDispatcher("template.jsp").forward(req, resp);
    }

}
