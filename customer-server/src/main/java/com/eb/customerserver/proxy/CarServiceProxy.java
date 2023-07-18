package com.eb.customerserver.proxy;

import com.eb.customerserver.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="car-service")
public interface CarServiceProxy {

    @GetMapping("/car/show/all")
    public List<CarPattern> getListOfCars();

}
