package com.fortech.serviceapi;

import com.fortech.model.dto.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<CarDto> readAllCarsDto();

    void saveCar(CarDto carDto);

    void updateCar(Long carId, CarDto carDto);

    void deleteCar(Long carId);

    boolean carExist(Long id);
}
