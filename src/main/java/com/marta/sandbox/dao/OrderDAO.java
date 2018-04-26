package com.marta.sandbox.dao;

import com.marta.sandbox.entity.Order;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OrderDAO extends AbstractDAO {

    public List<Order> getOrders() {
        return em.createQuery("SELECT e FROM Order e", Order.class).getResultList();
    }

    public List<Order> getOrdersByCustomerId(String customerId) {
        if (customerId == null || customerId.isEmpty()) return getOrders();
        return em.createQuery("SELECT e FROM Order e WHERE e.customer.id = :customerId", Order.class)
                .setParameter("customerId", customerId).getResultList();
    }

    public void persist(Order order) {
        if (order == null) return;
        em.persist(order);
    }

    public Order getOrderById(String id) {
        if (id == null) return null;
        return em.find(Order.class, id);
    }

    public void merge(Order order) {
        if (order == null) return;
        em.merge(order);
    }

    public void removeOrder(Order order) {
        if (order == null) return;
        em.remove(order);
    }

    public void removeOrder(String orderId) {
        if (orderId == null || orderId.isEmpty()) return;
        Order order = em.find(Order.class, orderId);
        em.remove(order);
    }
}
