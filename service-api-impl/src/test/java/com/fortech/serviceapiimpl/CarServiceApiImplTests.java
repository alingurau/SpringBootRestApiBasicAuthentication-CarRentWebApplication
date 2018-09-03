//package com.fortech.serviceapiimpl;
//
//import com.fortech.model.dto.CarDto;
//import com.fortech.model.entities.Car;
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
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static junit.framework.TestCase.assertTrue;
//import static org.junit.Assert.assertEquals;
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
//    Car car = new Car();
//    private String model = "BMW";
//    private String modelYear = "2018";
//    private String fuel = "DIESEL";
//    private String transmission = "MANUAL";
//    private String description = "All the power under one hood";
//    private double tariff = Double.parseDouble("50.25");
//
//    @Test
//    public void readAllCarsDto_ShouldReturnAList() {
//    List<Car> allCars = new ArrayList<>();
//    allCars.add(car);
//    when(carRepositoryMock.findAll()).thenReturn(allCars);
//
//    List<CarDto> result = carServiceImpl.readAllCarsDto();
//
//    List<CarDto> expect = new ArrayList<>();
//    expect.add(car.translateToCarDto());
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
//
//    @Test
//    public void addCar_ShouldReturnCarSaved()  {
//        Car car = new Car();
//        Car result = carServiceImpl.saveCar(car.translateToCarDto());
//
//        Car expect = carRepositoryMock.save(car);
//        assertEquals(result, expect);
//    }
//
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
//        Mockito.verify( carRepositoryMock.save(car));
//    }
//
//    @Test
//    public void deleteCar_ShouldVerifyIfMethodIsCalled() {
//        Car car= new Car();
//        carRepositoryMock.findById(car.getId());
//        carServiceImpl.deleteCar(car.getId());
//
//        Mockito.verify(carRepositoryMock, times(1)).deleteById(car.getId());
//    }
//
//}
