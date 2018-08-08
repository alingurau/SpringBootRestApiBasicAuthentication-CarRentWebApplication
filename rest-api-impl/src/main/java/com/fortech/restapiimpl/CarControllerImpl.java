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
    public ResponseEntity<List<CarDto>> readAllCars() {
        return new ResponseEntity<>(carService.readAllCarsDto(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity addCar(CarDto carDto) {
        carService.saveCar(carDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity updateCar(Long carId, CarDto carDto) {
        if(carDto != null){
            carService.updateCar(carId, carDto);
            return new ResponseEntity<String>("CAR UPDATED", HttpStatus.OK);
        }
     return new ResponseEntity<String>("INVALID INPUT", HttpStatus.BAD_REQUEST);}

    @Override
    public ResponseEntity deleteCarById(Long carId) {
        if(carId != null){
            carService.deleteCar(carId);
        }
        return new ResponseEntity("CAR DELETED", HttpStatus.OK);
    }
}
