package com.eb.carservice.controller;


import com.eb.carservice.model.Car;
import com.eb.carservice.pattern.CarPattern;
import com.eb.carservice.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/show/all")
    public List<Car> showList(){
        log.debug("All of the cars listed and showed.");
        return carService.getAllCars();
    }

    @DeleteMapping("/sell/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id){
        log.debug(id + " car deleted.");
        return carService.sellCar(id);

    }

    @GetMapping("/show/{id}")
    public Car getTheCarByID(@PathVariable int id) {

        Car theCar = carService.getCarByID(id);

        if (theCar == null) {
            throw new RuntimeException("Car id not found - " + id);
        }

        return theCar;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCar(@RequestBody CarPattern carPattern) {
        Car theCar = new Car();
        theCar.setColor(carPattern.getColor());
        theCar.setBrandName(carPattern.getBrandName());
        theCar.setModel(carPattern.getModel());
        theCar.setSold(carPattern.getSold());
        theCar.setYear(carPattern.getYear());
        log.debug("New car created.");
        return carService.addCar(theCar);
    }



}
