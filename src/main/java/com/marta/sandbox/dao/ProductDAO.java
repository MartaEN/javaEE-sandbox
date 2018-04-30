package com.marta.sandbox.dao;

import com.marta.sandbox.entity.Product;
import com.marta.sandbox.enums.Category;

import javax.ejb.Stateless;
import java.util.Collections;
import java.util.List;

@Stateless
public class ProductDAO extends AbstractDAO {

    public List<Product> getListProduct() {
        return em.createQuery("SELECT e FROM Product e", Product.class).getResultList();
    }

    public List<Product> getListProductByName (String name) {
        if (name == null || name.isEmpty()) return Collections.emptyList();
        return em.createQuery("SELECT e FROM Product e WHERE e.name = :name", Product.class)
                .setParameter("name", name).getResultList();
    }

    public List<Product> getListProductByCategory(String category) {
        if (category == null || category.isEmpty()) return getListProduct();
        return em.createQuery("SELECT e FROM Product e WHERE e.category = :category", Product.class)
                .setParameter("category", Category.valueOf(category)).getResultList();
    }

    public List<Product> getListProductByBrandId(String brandId) {
        if (brandId == null || brandId.isEmpty()) return getListProduct();
        return em.createQuery("SELECT e FROM Product e WHERE e.brand.id = :brandId", Product.class)
                .setParameter("brandId", brandId).getResultList();
    }

    public void persist(Product product) {
        if (product == null) return;
        em.persist(product);
    }

    public Product getProductById(String id) {
        if (id == null) return null;
        return em.find(Product.class, id);
    }

    public void merge(Product product) {
        if (product == null) return;
        em.merge(product);
    }

    public void removeProduct(Product product) {
        if (product == null) return;
        em.remove(product);
    }

    public void removeProduct(String productId) {
        if (productId == null || productId.isEmpty()) return;
        Product product = em.find(Product.class, productId);
        em.remove(product);
    }
}
