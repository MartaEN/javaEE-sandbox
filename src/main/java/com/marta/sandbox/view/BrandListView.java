package com.marta.sandbox.view;

import com.marta.sandbox.dao.BrandDAO;
import com.marta.sandbox.entity.Brand;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class BrandListView {

    private String brandName = "";

    @Inject
    private BrandDAO brandDAO;

    public String getBrandName() { return brandName; }
    public void setBrandName(String brand) { this.brandName = brand.toUpperCase(); }

    public List<Brand> getBrands () { return brandDAO.getBrands(); }

    public void addBrand() { brandDAO.persist(brandName); }

}
