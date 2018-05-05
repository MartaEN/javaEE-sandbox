package com.marta.sandbox.beans;

import com.marta.sandbox.dao.UserDAO;
import com.marta.sandbox.enums.UserRole;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Startup;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Startup
public class PrePopulateBean extends AbstractBean {

    @EJB
    private UserDAO userDAO;

    @PostConstruct
    public void createDummyData () throws NoSuchProviderException, NoSuchAlgorithmException {
        if(!userDAO.userExists("admin"))
            userDAO.registerNewUser("admin",
                String.valueOf(java.security.MessageDigest.getInstance("MD5").digest("admin123".getBytes())),
                UserRole.ADMIN);
        if(!userDAO.userExists("test-customer"))
            userDAO.registerNewUser("test-customer",
                String.valueOf(java.security.MessageDigest.getInstance("MD5").digest("password".getBytes())),
                UserRole.CUSTOMER);
    }
}
