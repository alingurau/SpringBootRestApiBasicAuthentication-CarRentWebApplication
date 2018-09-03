package com.fortech.serviceapiimpl;

import com.fortech.model.dto.CarDto;
import com.fortech.model.entities.Car;
import com.fortech.model.repositories.CarRepository;
import com.fortech.serviceapi.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public boolean ifCarIdExistsInDatabase(Long carId) {
        return carRepository.findById(carId).isPresent();
    }

    @Override
    public List<CarDto> readAllCarsDto() {
        return carRepository.findAll()
                .stream()
                .map(Car::carDto)
                .collect(Collectors.toList());
    }

    @Override
    public Car addCar(CarDto carDto) {
        Car car = new Car();
        car.update(carDto);
        carRepository.save(car);
        return car;
    }

    @Override
    public Car updateCar(Long carId, CarDto carDto) {
        Car car =  carRepository.findById(carId).get();
        car.update(carDto);
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.findAll().forEach(car -> {
            carRepository.deleteById(carId);
        });
    }
}
