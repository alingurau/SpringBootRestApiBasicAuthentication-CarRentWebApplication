package com.fortech.serviceapiimpl;

import com.fortech.model.dto.CarDto;
import com.fortech.model.entities.CarEntity;
import com.fortech.model.repositories.CarRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CarServiceApiImplTests {

    @InjectMocks
    private CarServiceImpl carServiceImpl;

    @Mock
    private CarRepository carRepositoryMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    private String model = "BMW";
    private String modelYear = "2018";
    private String fuel = "DIESEL";
    private String transmission = "MANUAL";
    private String description = "All the power under one hood";
    private String tariff = "50";

    @Test
    public void readAllCarsDto_ShouldReturnAList() {

        CarEntity carTest = new CarEntity();

        carTest.setModel(model);
        carTest.setModelYear(modelYear);
        carTest.setFuel(fuel);
        carTest.setTransmission(transmission);
        carTest.setDescription(description);
        carTest.setTariff(tariff);
        List<CarEntity> carEntities= Arrays.asList(carTest);

        when(carRepositoryMock.findAll()).thenReturn(carEntities);

        List<CarDto> result =carServiceImpl.readAllCarsDto();

        assertEquals(1,result.size());
        CarDto resultCar = result.get(0);
        assertEquals(model, resultCar.getModel());
        assertEquals(modelYear, resultCar.getModelYear());
        assertEquals(fuel, resultCar.getFuel());
        assertEquals(transmission, resultCar.getTransmission());
        assertEquals(description, resultCar.getDescription());
        assertEquals(tariff, resultCar.getTariff());
    }

    @Test
    public void readAllCars_ShouldReturnEmptyList(){

        List<CarDto> result = carServiceImpl.readAllCarsDto();

        assertTrue(result.isEmpty());
    }

//    @Test
//    public void addCar_ShouldReturnCarSaved()  {
//        CarEntity carEntity = new CarEntity();
//        CarDto carDto = new CarDto();
//
//
//        CarEntity result = carServiceImpl.saveCar;
//
//        CarEntity expected = carRepositoryMock.save(carEntity);
//        assertEquals(expected, result);
//    }

//    @Test
//    public void saveCar_ShouldVerifyIfMethodIsCalled(){
//
//        CarDto carDto = new CarDto();
//        carDto.setModel(model);
//        carDto.setModelYear(modelYear);
//        carDto.setFuel(fuel);
//        carDto.setTransmission(transmission);
//        carDto.setDescription(description);
//        carDto.setTariff(tariff);
//
//        carServiceImpl.saveCar(carDto);
//
//        Mockito.verify(carRepositoryMock, times(1).save(argThat(car->carDto.getModel()
//                .equals(modelYear)&& carDto.getModelYear().equals(modelYear))));
//    }

}
