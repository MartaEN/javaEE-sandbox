package com.marta.sandbox.view;

import com.marta.sandbox.dao.ProductDAO;
import com.marta.sandbox.entity.Product;
import org.primefaces.event.SelectEvent;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ProductListView implements Serializable {

    @Inject
    private ProductDAO dao;

    private Product selectedProduct;

    public ProductListView () {}

    public List<Product> getProducts() {
        return new ArrayList<>(dao.getListProduct());
    }

    public void addProduct() {
        dao.persist(new Product());
    }

    public void remove(Product product) {
        dao.removeProduct(product.getId());
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Item Selected", ((Product)event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}