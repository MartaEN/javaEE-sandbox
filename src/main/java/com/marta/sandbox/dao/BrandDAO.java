package com.marta.sandbox.dao;

import com.marta.sandbox.entity.Brand;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class BrandDAO extends AbstractDAO {

    public List<Brand> getBrands() {
        return em.createQuery("SELECT e FROM Brand e", Brand.class).getResultList();
    }

    public void persist(Brand brand) {
        if (brand == null) return;
        em.persist(brand);
    }

    public void persist(String brandName) {
        if (brandName == null) return;
        em.persist(new Brand(brandName));
    }


    public Brand getBrandById(String id) {
        if (id == null) return null;
        return em.find(Brand.class, id);
    }

    public void merge(Brand brand) {
        if (brand == null) return;
        em.merge(brand);
    }

    public void removeBrand(Brand brand) {
        if (brand == null) return;
        em.remove(brand);
    }

    public void removeBrand (String brandId) {
        if (brandId == null || brandId.isEmpty()) return;
        Brand brand = em.find(Brand.class, brandId);
        em.remove(brand);
    }

}
