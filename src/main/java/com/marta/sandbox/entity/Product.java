package com.marta.sandbox.entity;

import com.marta.sandbox.enums.Category;

import javax.persistence.*;

@Entity
public class Product extends AbstractEntity {

    @Column (nullable = false)
    protected String name = "";

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Brand brand;

    protected float price;

    protected String image;

    @Column (columnDefinition = "TEXT")
    protected String description;

    private boolean inStock = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCategory (String category) { this.category = Category.valueOf(category); }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean available) {
        this.inStock = available;
    }

}