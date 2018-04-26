package com.marta.sandbox.service;

import com.marta.sandbox.dbservice.DBServiceDummy;
import com.marta.sandbox.entity.Product;

import javax.ejb.Stateful;
import javax.inject.Named;
import java.util.List;

@Named
@Stateful
public class CustomerService {

    public List<Product> getRandomProducts (int howMany) {
        return DBServiceDummy.getInstance().getRandomProducts(6);
    }

}
