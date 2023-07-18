package com.eb.carservice.service;

import com.eb.carservice.model.Car;
import com.eb.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        List<Car> carList = carRepository.findAll();
        return carList;
    }

    @Override
    public Car getCarByID(int id) {
        Optional<Car> a = carRepository.findById(id);
        Car carTemp = null;
        if (a.isPresent()) {
            carTemp= a.get();
        }
        else {
            throw new RuntimeException("Did not find car id: " + id);
        }

        return carTemp;
    }

    @Override
    public ResponseEntity<String> addCar(Car theCar) {
        carRepository.save(theCar);
        return new ResponseEntity<>("Created and saved: "+ theCar, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> sellCar(int id) {
        Car theCar = getCarByID(id);
        carRepository.delete(theCar);
        return new ResponseEntity<>("Deleted: "+ theCar, HttpStatus.ACCEPTED);
    }


}
