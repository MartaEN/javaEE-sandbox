package com.marta.sandbox.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "auth")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if(request.getAttribute("username") == null)
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_FORBIDDEN);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
