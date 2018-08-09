package com.fortech.restapiimpl;

import com.fortech.model.dto.CarDto;
import com.fortech.restapi.CarController;
import com.fortech.serviceapi.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CarControllerImpl implements CarController {

    @Autowired
    CarService carService;

    @Override
    public List<CarDto> readAllCars() {
        return carService.readAllCarsDto();
    }

    @Override
    public ResponseEntity addCar(CarDto carDto) {
        if (carDto != null) {
            carService.saveCar(carDto);
            return new ResponseEntity<>("CAR SAVED", HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity updateCar(Long carId, CarDto carDto) {
        if (carService.carExist(carId)) {
            carService.updateCar(carId, carDto);
            return new ResponseEntity<>("CAR UPDATED", HttpStatus.OK);
        }
        return new ResponseEntity<String>("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity deleteCarById(Long carId) {
        if (carService.carExist(carId)) {
            carService.deleteCar(carId);
            return new ResponseEntity<>("CAR DELETED", HttpStatus.OK);
        }
        return new ResponseEntity<String>("BAD REQUEST", HttpStatus.BAD_REQUEST);
    }
}
