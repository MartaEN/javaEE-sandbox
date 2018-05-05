package com.marta.sandbox.beans;

import com.marta.sandbox.logger.DebugLogger;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
@RequestScoped
@Interceptors(DebugLogger.class)
public class UserSession extends AbstractBean {

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "logged-out?faces-redirect=true";
    }

    public boolean isUserLoggedIn() {
        String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        return  !((user == null)|| user.isEmpty());
    }

}
