package com.marta.sandbox.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "general")
public class AllPagesFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //это домашка
        response.setContentType ("text/html;charset=UTF-8");

        //а это я пытаюсь дополнительно куки и прочие радости добыть на стадии фильтра
        HttpServletRequest req = (HttpServletRequest) request;

        StringBuilder info = new StringBuilder();
        String username = null;

        info.append("SessionID = ").append(req.getSession().getId()).append("<br>");

        Cookie cookies [] = req.getCookies();
        if (cookies == null)
            info.append("NoCookies<br>");
        else {
            for (Cookie c : cookies) {
                info.append("Cookie: ").append(c.getName())
                        .append(" = ").append(c.getValue()).append("<br>");
                if(c.getName().equals("username")) username = c.getValue();
            }
        }

        request.setAttribute("info", info.toString());
        request.setAttribute("username", username);
        //сорри, три пункта ниже наверняка делаются на странице жаваскриптом, но я пока не умею
        request.setAttribute("user-info", username == null ?
                "Пользователь не авторизован" : "Выполнен вход под именем " + username);
        request.setAttribute("auth-link", username == null ? "sign-in" : "sign-out");
        request.setAttribute("auth-text", username == null ? "Войти" : "Выйти");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
