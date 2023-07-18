package com.eb.customerserver.service;

import com.eb.customerserver.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> showListCustomers();
    Customer showCustomerByID(int id);
    Customer addCustomer(Customer customer);
    void customerBuyCar(Customer customer);
}
