package com.marta.sandbox.servlet;

import com.marta.sandbox.beans.CartBean;
import com.marta.sandbox.dbservice.DBServiceDummy;
import com.marta.sandbox.entity.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Inject
    private CartBean cart;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/pages/client/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product selectedProduct = DBServiceDummy.getInstance().getProductByID((req.getParameter("id")));
        if(selectedProduct!= null) cart.addItem(selectedProduct, 1);
        req.getRequestDispatcher("WEB-INF/pages/client/cart.jsp").forward(req, resp);
    }
}
