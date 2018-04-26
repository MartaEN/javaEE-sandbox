package com.marta.sandbox.entity;

import com.marta.sandbox.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Order extends AbstractEntity {

    @Column (columnDefinition = "DATETIME")
    private LocalDate date;

    @ManyToOne
    private Customer customer;

    @Column (nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

//    @ManyToMany
//    private List<Product> items;

    public Order() {
        this.date = LocalDate.now();
        this.status = OrderStatus.NEW;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

//    public List<Product> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Product> items) {
//        this.items = items;
//    }
}

