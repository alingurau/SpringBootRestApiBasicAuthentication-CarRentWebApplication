package com.fortech.serviceapiimpl;

import com.fortech.model.dto.CarDto;
import com.fortech.model.entities.CarEntity;
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
    public List<CarDto> readAllCarsDto() {
        return carRepository.findAll()
                .stream()
                .map(CarEntity::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveCar(CarDto carDto) {
        CarEntity carEntity = new CarEntity();
        carEntity.update(carDto);
        carRepository.save(carEntity);
    }

    @Override
    public void updateCar(Long carId, CarDto carDto) {
        carRepository.findById(carId);
        CarEntity carEntity = new CarEntity();
        carEntity.update(carDto);
        carRepository.save(carEntity);
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.findAll().forEach(carEntity -> {
            carRepository.deleteById(carId);
        });

    }
}
