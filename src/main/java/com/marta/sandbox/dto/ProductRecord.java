package com.marta.sandbox.dto;

import com.marta.sandbox.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRecord {

    private String id;
    private String name;
    private String category;
    private String brandId;
    private float price;
    private String image;
    private String description;
    private boolean inStock;

    public ProductRecord(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.category = (product.getCategory()).getName();
        this.brandId = (product.getBrand()).getId();
        this.price = product.getPrice();
        this.image = product.getImage();
        this.description = product.getDescription();
        this.inStock = product.isInStock();
    }

    public ProductRecord () {}

    public static List<ProductRecord> toList (List<Product> products) {
        if (products == null || products.isEmpty()) return Collections.emptyList();
        final List<ProductRecord> result = new ArrayList<>();
        for (Product product: products) {
            if (product == null) continue;
            result.add(new ProductRecord(product));
        }
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "ProductRecord{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", brandId='" + brandId + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", inStock=" + inStock +
                '}';
    }
}
