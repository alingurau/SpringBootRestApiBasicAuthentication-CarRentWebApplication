package com.fortech.serviceapiimpl;

import com.fortech.model.dto.CarDto;
import com.fortech.model.entities.Car;
import com.fortech.model.repositories.CarRepository;
import com.fortech.serviceapi.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public boolean carIdExists(Long id) {
        return carRepository.findById(id).isPresent();
    }

    @Override
    public List<CarDto> listAllCarsAvailable() {
        List<CarDto> cars = new ArrayList<>();
        carRepository.findAll().forEach((car) -> {
            cars.add(car.carDto());
        });
        return cars;
    }


    @Override
    public Car addCar(CarDto carDto) {
        Car car = new Car();
        car.update(carDto);
        car.setAvailability(false);
        carRepository.save(car);
        return car;
    }

    @Override
    public Car updateCar(Long carId, CarDto carDto) {
        Car car = carRepository.findById(carId).get();
        car.update(carDto);
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
