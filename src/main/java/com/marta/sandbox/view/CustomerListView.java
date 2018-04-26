package com.marta.sandbox.view;

import com.marta.sandbox.dao.CustomerDAO;
import com.marta.sandbox.entity.Customer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class CustomerListView {

    private String customerName;

    @Inject
    private CustomerDAO customerDAO;

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String brand) { this.customerName = brand.toUpperCase(); }

    public List<Customer> getCustomers () { return customerDAO.getListCustomer(); }

    public void addCustomer() { customerDAO.persist(customerName); }

}
