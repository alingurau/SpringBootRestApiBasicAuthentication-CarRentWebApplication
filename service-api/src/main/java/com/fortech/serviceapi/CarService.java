package com.fortech.serviceapi;

import com.fortech.model.dto.CarDto;
import com.fortech.model.entities.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<CarDto> readAllCarsDto();

    Car addCar(CarDto carDto);

    Car updateCar(Long carId, CarDto carDto);

    void deleteCar(Long carId);

    boolean ifCarIdExistsInDatabase(Long carId);

}
