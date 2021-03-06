package com.marta.sandbox.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkout")
@ServletSecurity(
        @HttpConstraint(    rolesAllowed = {"ADMIN", "CUSTOMER"},
                            transportGuarantee = ServletSecurity.TransportGuarantee.NONE ))
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/client/checkout.jsp").forward(req, resp);
    }
}
