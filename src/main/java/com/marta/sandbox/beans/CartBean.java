package com.marta.sandbox.beans;

import com.marta.sandbox.entity.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named("cart")
@SessionScoped
public class CartBean extends AbstractBean {

    private Map<Product, Integer> items = new HashMap<>();

    public void setItems(Map<Product, Integer> items) {
        this.items = items;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void addItem (Product product, int quantity) {
        items.put(product, quantity + items.getOrDefault(product, 0));
    }

    public void reduceItemCountBy (Product product, int quantity) {
        int newQuantity = items.get(product) - quantity;
        if (newQuantity <= 0) items.remove(product);
        else items.put(product, newQuantity);
    }

    public void removeItem (Product product) {
        items.remove(product);
    }

}
