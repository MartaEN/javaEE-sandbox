package com.marta.sandbox.servlet;

import com.marta.sandbox.dbservice.DBServiceDummy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("page", "home");
        req.setAttribute("products", DBServiceDummy.getInstance().getRandomProducts(6));
        req.getRequestDispatcher("WEB-INF/pages/client/home.jsp").forward(req, resp);
    }
}
