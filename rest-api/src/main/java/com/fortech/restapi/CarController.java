package com.fortech.restapi;

import com.fortech.model.dto.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/cars")
public interface CarController {

    @GetMapping("/readAll")
    List<CarDto> readAllCars();

    @PostMapping("/addCar")
    ResponseEntity addCar(@RequestBody CarDto carDto);

    @PutMapping("/updateCar/{carId}")
    ResponseEntity updateCar(@PathVariable Long carId, @RequestBody CarDto carDto);

    @DeleteMapping("/deleteCar/{carId}")
    ResponseEntity deleteCarById(@PathVariable Long carId);
}
