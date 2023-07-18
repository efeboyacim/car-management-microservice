package com.eb.carservice.service;

import com.eb.carservice.model.Car;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    Car getCarByID(int id);
    ResponseEntity<String> addCar(Car car);
    ResponseEntity<String> sellCar(int id);
}
