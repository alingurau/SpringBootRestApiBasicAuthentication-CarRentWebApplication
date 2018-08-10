//package com.fortech.serviceapiimpl;
//
//import com.fortech.model.dto.CarDto;
//import com.fortech.model.entities.CarEntity;
//import com.fortech.model.repositories.CarRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static junit.framework.TestCase.assertTrue;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.argThat;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.Silent.class)
//public class CarServiceApiImplTests {
//
//    @InjectMocks
//    private CarServiceImpl carServiceImpl;
//
//    @Mock
//    private CarRepository carRepositoryMock;
//
////    @Before
////    public void setup() {
////        MockitoAnnotations.initMocks(this);
////    }
//
//    CarEntity carEntity = new CarEntity();
//    private String model = "BMW";
//    private String modelYear = "2018";
//    private String fuel = "DIESEL";
//    private String transmission = "MANUAL";
//    private String description = "All the power under one hood";
//    private String tariff = "50";
//
//    @Test
//    public void readAllCarsDto_ShouldReturnAList() {
//    List<CarEntity> allCars = new ArrayList<>();
//    allCars.add(carEntity);
//    when(carRepositoryMock.findAll()).thenReturn(allCars);
//
//    List<CarDto> result = carServiceImpl.readAllCarsDto();
//
//    List<CarDto> expect = new ArrayList<>();
//    expect.add(carEntity.toDto());
//    Assert.assertEquals(result,expect);
//
//    }
//
//    @Test
//    public void readAllCars_ShouldReturnEmptyList(){
//
//        List<CarDto> result = carServiceImpl.readAllCarsDto();
//
//        assertTrue(result.isEmpty());
//    }

//    @Test
//    public void addCar_ShouldReturnCarSaved()  {
//        CarEntity carEntity = new CarEntity();
//        CarEntity result = carServiceImpl.saveCar(carEntity.toDto());
//
//        CarEntity expect = carRepositoryMock.save(carEntity);
//        assertEquals(result, expect);
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
//        Mockito.verify(carRepositoryMock, times(1).save(carDto));
//    }
//
//    @Test
//    public void deleteCar_ShouldVerifyIfMethodIsCalled() {
//        CarEntity carEntity = new CarEntity();
//        carRepositoryMock.findById(carEntity.getId());
//        carServiceImpl.deleteCar(carEntity.getId());
//
//        Mockito.verify(carRepositoryMock, times(1)).deleteById(carEntity.getId());
//    }
//
//}
