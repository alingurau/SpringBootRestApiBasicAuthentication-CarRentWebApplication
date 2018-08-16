//package com.fortech.restapiimpl;
//
//import com.fortech.model.dto.CarDto;
//import com.fortech.model.entities.CarEntity;
//import com.fortech.serviceapi.CarService;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//
//@RunWith(MockitoJUnitRunner.Silent.class)
//public class CarControllerApiImplTests {
//
//    @InjectMocks
//    CarControllerImpl carControllerImpl;
//
//    @Mock
//    CarService carServiceMock;
//
//    CarDto  carDto= new CarDto();
//    private String model = "Mercedes-Benz";
//    private String modelYear = "2018";
//    private String fuel = "DIESEL";
//    private String transmission = "automat";
//    private String description = "Best car of the year";
//    private String tariff = "25";
//
//    @Test
//    public void readAllCars_ShouldReturnAList() {
//       List<CarDto> allCars = new ArrayList<>();
//       allCars.add(carDto);
//       when(carServiceMock.readAllCarsDto()).thenReturn(allCars);
//
//       List<CarDto> result = carControllerImpl.readAllCars();
//
//       assertEquals(allCars, result);
//    }
//
//    @Test
//    public void saveCar_ShouldReturnHttpStatusOk() {
//        CarDto carDto = new CarDto();
//        carDto.setModel(model);
//        carDto.setModelYear(modelYear);
//        carDto.setFuel(fuel);
//        carDto.setTransmission(transmission);
//        carDto.setDescription(description);
//        carDto.setTariff(tariff);
//
//        ResponseEntity result = carControllerImpl.addCar(carDto);
//
//        ResponseEntity expect = new ResponseEntity<>("CAR SAVED", HttpStatus.CREATED);
//        assertEquals(result, expect);
//    }
//
//    @Test
//    public void saveCar_ShouldReturnHttpStatusBadRequest() {
//        ResponseEntity result = carControllerImpl.addCar(null);
//
//        ResponseEntity expect = new ResponseEntity<>("INVALID INPUT", HttpStatus.BAD_REQUEST);
//        assertEquals(result, expect);
//    }
//
//    @Test
//    public void updateCar_ShouldReturnHttpStatusOK() {
//        CarEntity carEntity = new CarEntity();
//        CarDto carDto = new CarDto();
//        when(carServiceMock.ifCarIdExistsInDatabase(carEntity.getId())).thenReturn(true);
//
//        ResponseEntity result = carControllerImpl.updateCar(carEntity.getId(), carDto);
//
//        ResponseEntity expect = new ResponseEntity<>("CAR UPDATED", HttpStatus.OK);
//        assertEquals(result, expect);
//
//    }
//
//    @Test
//    public void updateCar_ShouldReturnHttpStatusBadRequest() {
//        CarEntity carEntity = new CarEntity();
//        CarDto carDto = new CarDto();
//
//        ResponseEntity result = carControllerImpl.updateCar(carEntity.getId(), carDto);
//
//        ResponseEntity expect = new ResponseEntity<>("INVALID INPUT", HttpStatus.BAD_REQUEST);
//        assertEquals(result, expect);
//    }
//
//    @Test
//    public void deleteCar_ShouldReturnHttpStatusOK() {
//        CarEntity carEntity = new CarEntity();
//
//        when(carServiceMock.ifCarIdExistsInDatabase(carEntity.getId())).thenReturn(true);
//        ResponseEntity result = carControllerImpl.deleteCarById(carEntity.getId());
//
//        ResponseEntity expect = new ResponseEntity<>("CAR DELETED", HttpStatus.OK);
//        assertEquals(result, expect);
//    }
//
//    @Test
//    public void deleteCar_ShouldReturnHttpStatusBadRequest() {
//        CarEntity carEntity = new CarEntity();
//
//        when(carServiceMock.ifCarIdExistsInDatabase(carEntity.getId())).thenReturn(false);
//
//        ResponseEntity result = carControllerImpl.deleteCarById(carEntity.getId());
//
//        ResponseEntity expect = new ResponseEntity("BAD REQUEST", HttpStatus.BAD_REQUEST);
//        assertEquals(result, expect);
//    }
//}
