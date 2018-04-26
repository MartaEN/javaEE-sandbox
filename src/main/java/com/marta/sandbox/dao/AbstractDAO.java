package com.marta.sandbox.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO {

    @PersistenceContext(unitName = "sandbox-persistence-unit")
    protected EntityManager em;
}
