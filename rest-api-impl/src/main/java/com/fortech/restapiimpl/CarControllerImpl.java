package com.fortech.restapiimpl;

import com.fortech.model.dto.CarDto;
import com.fortech.restapi.CarController;
import com.fortech.serviceapi.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CarControllerImpl implements CarController {

    @Autowired
    CarService carService;

    @Override
    public List<CarDto> listAllCars() {
        return carService.listAllCarsAvailable();
    }

    @Override
    public ResponseEntity addCar(@RequestBody  CarDto carDto) {
        if (carDto != null) {
            carService.addCar(carDto);
            return new ResponseEntity<>("CAR SAVED", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity updateCar(Long id, CarDto carDto) {
        if (carService.carIdExists(id)) {
            carService.updateCar(id, carDto);
            return new ResponseEntity<>("CAR UPDATED", HttpStatus.OK);
        }
        return new ResponseEntity<>("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity deleteCar(Long id) {
        if (carService.carIdExists(id)) {
            carService.deleteCar(id);
            return new ResponseEntity<>("CAR DELETED", HttpStatus.OK);
        }
        return new ResponseEntity<>("BAD REQUEST", HttpStatus.BAD_REQUEST);
    }
}
