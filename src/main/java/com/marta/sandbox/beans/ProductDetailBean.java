package com.marta.sandbox.beans;

import com.marta.sandbox.entity.Product;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("details")
@RequestScoped
public class ProductDetailBean extends  AbstractBean {

    @Inject
    private CartBean cart;

    public String orderItem (Product product) {
        cart.addItem(product, 1);
        return "/home";
    }

}
