package com.marta.sandbox.view;

import com.marta.sandbox.dao.ProductDAO;
import com.marta.sandbox.entity.Product;
import com.marta.sandbox.logger.DebugLogger;
import org.primefaces.event.SelectEvent;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
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

    @Interceptors(DebugLogger.class)
    public List<Product> getProducts() {
        return new ArrayList<>(dao.getListProduct());
    }

    @Interceptors(DebugLogger.class)
    public void addProduct() {
        dao.persist(new Product());
    }

    @Interceptors(DebugLogger.class)
    public void remove(Product product) {
        dao.removeProduct(product.getId());
    }

    @Interceptors(DebugLogger.class)
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    @Interceptors(DebugLogger.class)
    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    @Interceptors(DebugLogger.class)
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Item Selected", ((Product)event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}