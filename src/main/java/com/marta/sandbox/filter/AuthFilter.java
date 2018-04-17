package com.marta.sandbox.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(filterName = "auth", urlPatterns = "/checkout")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Cookie[] cookies = ((HttpServletRequest)request).getCookies();

        if (cookies == null) {
            ((HttpServletResponse)response).sendRedirect("sign-in");

        } else if (Arrays.stream(cookies).anyMatch(c -> c.getName().equals("username"))) {
            request.setAttribute("username",
                    Arrays.stream(cookies)
                        .filter(c -> c.getName().equals("username"))
                        .findFirst()
                        .map(Cookie::getValue)
                        .orElse(""));
            chain.doFilter(request, response);

        } else ((HttpServletResponse)response).sendRedirect("sign-in");
    }

    @Override
    public void destroy() {

    }
}
