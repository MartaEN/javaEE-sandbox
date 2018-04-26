package com.marta.sandbox.dao;

import com.marta.sandbox.entity.Customer;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CustomerDAO extends AbstractDAO {

    public List<Customer> getListCustomer() {
        return em.createQuery("SELECT e FROM Customer e", Customer.class).getResultList();
    }

    public void persist(Customer customer) {
        if (customer == null) return;
        em.persist(customer);
    }

    public void persist(String customerName) {
        if (customerName == null) return;
        em.persist(new Customer(customerName));
    }


    public Customer getCustomerById(String id) {
        if (id == null) return null;
        return em.find(Customer.class, id);
    }

    public void merge(Customer customer) {
        if (customer == null) return;
        em.merge(customer);
    }

    public void removeCustomer(Customer customer) {
        if (customer == null) return;
        em.remove(customer);
    }

    public void removeCustomer (String customerId) {
        if (customerId == null || customerId.isEmpty()) return;
        Customer customer = em.find(Customer.class, customerId);
        em.remove(customer);
    }
}
