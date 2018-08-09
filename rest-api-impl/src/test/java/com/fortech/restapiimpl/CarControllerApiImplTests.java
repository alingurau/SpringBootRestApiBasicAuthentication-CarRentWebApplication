package com.fortech.restapiimpl;

import com.fortech.model.dto.CarDto;
import com.fortech.model.entities.CarEntity;
import com.fortech.serviceapi.CarService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.Silent.class)
public class CarControllerApiImplTests {

    @InjectMocks
    CarControllerImpl carControllerImpl;

    @Mock
    CarService carServiceMock;

    private String model = "Mercedes-Benz";
    private String modelYear = "2018";
    private String fuel = "DIESEL";
    private String transmission = "automat";
    private String description = "Best car of the year";
    private String tariff = "25";

    @Test
    public void readAllCars_ShouldReturnAList() {
        CarEntity carEntity = new CarEntity();
        carEntity.setModel(model);
        carEntity.setModelYear(modelYear);
        carEntity.setFuel(fuel);
        carEntity.setTransmission(transmission);
        carEntity.setDescription(description);
        carEntity.setTariff(tariff);
        List<CarDto> carEntities = Collections.singletonList(carEntity.toDto());

        when(carServiceMock.readAllCarsDto()).thenReturn(carEntities);

        List<CarDto> result = carControllerImpl.readAllCars();

        assertEquals(1, result.size());
        CarDto resultCar = result.get(0);
        assertEquals(model, resultCar.getModel());
        assertEquals(modelYear, resultCar.getModelYear());
        assertEquals(fuel, resultCar.getFuel());
        assertEquals(transmission, resultCar.getTransmission());
        assertEquals(description, resultCar.getDescription());
        assertEquals(tariff, resultCar.getTariff());
    }

    @Test
    public void saveCar_ShouldReturnHttpStatusOk() {
        CarDto carDto = new CarDto();
        carDto.setModel(model);
        carDto.setModelYear(modelYear);
        carDto.setFuel(fuel);
        carDto.setTransmission(transmission);
        carDto.setDescription(description);
        carDto.setTariff(tariff);

        ResponseEntity result = carControllerImpl.addCar(carDto);

        ResponseEntity expect = new ResponseEntity<>("CAR SAVED", HttpStatus.CREATED);
        assertEquals(result, expect);
    }

    @Test
    public void saveCar_ShouldReturnHttpStatusBadRequest() {
        ResponseEntity result = carControllerImpl.addCar(null);

        ResponseEntity expect = new ResponseEntity<>("INVALID INPUT", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }

    @Test
    public void updateCar_ShouldReturnHttpStatusOK() {
        CarEntity carEntity = new CarEntity();
        CarDto carDto = new CarDto();
        when(carServiceMock.carExist(carEntity.getId())).thenReturn(true);

        ResponseEntity result = carControllerImpl.updateCar(carEntity.getId(), carDto);

        ResponseEntity expect = new ResponseEntity<>("CAR UPDATED", HttpStatus.OK);
        assertEquals(result, expect);

    }

    @Test
    public void updateCar_ShouldReturnHttpStatusBadRequest() {
        CarEntity carEntity = new CarEntity();
        CarDto carDto = new CarDto();

        ResponseEntity result = carControllerImpl.updateCar(carEntity.getId(), carDto);

        ResponseEntity expect = new ResponseEntity<>("INVALID INPUT", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }

    @Test
    public void deleteCar_ShouldReturnHttpStatusOK() {
        CarEntity carEntity = new CarEntity();

        when(carServiceMock.carExist(carEntity.getId())).thenReturn(true);
        ResponseEntity result = carControllerImpl.deleteCarById(carEntity.getId());

        ResponseEntity expect = new ResponseEntity<>("CAR DELETED", HttpStatus.OK);
        assertEquals(result, expect);
    }

    @Test
    public void deleteCar_ShouldReturnHttpStatusBadRequest() {
        CarEntity carEntity = new CarEntity();

        when(carServiceMock.carExist(carEntity.getId())).thenReturn(false);

        ResponseEntity result = carControllerImpl.deleteCarById(carEntity.getId());

        ResponseEntity expect = new ResponseEntity("BAD REQUEST", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }
}
