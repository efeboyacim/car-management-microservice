package com.eb.customerserver.service;

import com.eb.customerserver.model.Customer;
import com.eb.customerserver.proxy.CarServiceProxy;
import com.eb.customerserver.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CarServiceProxy carServiceProxy;


    @Override
    public List<Customer> showListCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer showCustomerByID(int id) {
        Optional<Customer> a = customerRepository.findById(id);
        Customer custTemp = null;
        if (a.isPresent()) {
            custTemp= a.get();
        }
        else {
            throw new RuntimeException("Did not find customer id: " + id);
        }

        return custTemp;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void customerBuyCar(Customer customer) {
        customer.setBuyCarBefore("Yes");

    }
}
