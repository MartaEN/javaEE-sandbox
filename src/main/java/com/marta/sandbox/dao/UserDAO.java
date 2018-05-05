package com.marta.sandbox.dao;

import com.marta.sandbox.entity.Users;
import com.marta.sandbox.enums.UserRole;

import javax.ejb.Stateless;

@Stateless
public class UserDAO extends  AbstractDAO{

    public boolean userExists (String username) {
        if (username == null || username.isEmpty()) return false;
        return !em.createQuery("SELECT e FROM Users e WHERE e.username = :username", Users.class)
                .setParameter("username", username).getResultList().isEmpty();
    }

    public void registerNewCustomer (String username, String password) {
        em.persist(new Users(username, password, UserRole.CUSTOMER));
    }

    public void registerNewUser (String username, String password, UserRole role) {
        em.persist(new Users(username, password, role));
    }
}
