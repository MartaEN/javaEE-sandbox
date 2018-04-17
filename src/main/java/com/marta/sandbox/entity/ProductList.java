package com.marta.sandbox.entity;

import java.util.List;

public class ProductList {

    private List<Product> list;

    public ProductList(List list) {
        this.list = list;
    }

    public List<Product> getList() {
        return list;
    }

}
