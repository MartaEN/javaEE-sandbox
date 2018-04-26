package com.marta.sandbox.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand extends AbstractEntity {

    @Column(nullable = false, unique = true, length = 63)
    private String name = "";

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "brand")
    private List<Product> products = new ArrayList<>();

    public Brand() { }

    public Brand(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
