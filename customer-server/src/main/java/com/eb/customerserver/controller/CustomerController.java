package com.eb.customerserver.controller;

import com.eb.customerserver.model.Customer;
import com.eb.customerserver.pattern.CustomerPattern;
import com.eb.customerserver.proxy.CarPattern;
import com.eb.customerserver.proxy.CarServiceProxy;
import com.eb.customerserver.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CarServiceProxy carServiceProxy;

    @GetMapping("/show/all")
    private List<Customer> findAll(){
        log.debug("Customers listed.");
        return customerService.showListCustomers();
    }

    @GetMapping("/show/{id}")
    public Customer getTheCustomerByID(@PathVariable int id) {

        Customer theC = customerService.showCustomerByID(id);

        if (theC == null) {
            throw new RuntimeException("Car id not found - " + id);
        }

        return theC;
    }

    @PostMapping("/create")
    public String createCustomer(@RequestBody CustomerPattern customerPattern) {
        Customer c = new Customer();
        c.setAge(customerPattern.getAge());
        c.setBuyCarBefore(customerPattern.getBuyCarBefore());
        c.setFullName(customerPattern.getFullName());

        log.debug("New car created.");
        customerService.addCustomer(c);
        return ("New customer created with id :" + c.getId());

    }

    @GetMapping("/car/show/all")
    public List<CarPattern> feignCarList(){
        log.debug("Cars listed.");
        return carServiceProxy.getListOfCars();
    }

}
