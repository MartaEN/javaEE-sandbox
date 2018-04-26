package com.marta.sandbox.view;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public abstract class AbstractView {

    protected String getParameter(String name) {
        return getHttpServletRequest().getParameter(name);
    }

    public HttpServletRequest getHttpServletRequest() {
        final FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest) context.getExternalContext().getRequest();
    }

}
