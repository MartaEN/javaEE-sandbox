package com.marta.sandbox.servlet;

import com.marta.sandbox.dbservice.DBService;
import com.marta.sandbox.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("page", "products");

        Product selectedProduct = DBService.getInstance().getProductByID((req.getParameter("id")));
        if (selectedProduct == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
        } else {
            req.setAttribute("product", selectedProduct);
            req.getRequestDispatcher("WEB-INF/pages/product.jsp").forward(req, resp);
        }
    }
}
