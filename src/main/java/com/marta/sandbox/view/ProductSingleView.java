package com.marta.sandbox.view;

import com.marta.sandbox.dao.BrandDAO;
import com.marta.sandbox.dao.ProductDAO;
import com.marta.sandbox.entity.Brand;
import com.marta.sandbox.entity.Product;
import com.marta.sandbox.enums.Category;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
public class ProductSingleView extends AbstractView {

    private final String id = getParameter("id");
    private Product product;

    @Inject
    private ProductDAO productDAO;

    @Inject
    private BrandDAO brandDAO;

    @PostConstruct
    private void init() { this.product = productDAO.getProductById(id); }

    public ProductSingleView () { }

    public List<Brand> getBrands () { return brandDAO.getBrands(); }

    public List<Category> getCategories () { return Arrays.asList(Category.values()); }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String save() {
        productDAO.merge(product);
        return "products";
    }

}
