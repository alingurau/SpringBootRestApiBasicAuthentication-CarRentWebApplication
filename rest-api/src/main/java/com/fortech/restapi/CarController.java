package com.fortech.restapi;

import com.fortech.model.dto.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/car")
public interface CarController {

    @GetMapping("/list")
    List<CarDto> listAllCars();

    @PostMapping("/add")
    ResponseEntity addCar(@RequestBody CarDto carDto);

    @PutMapping("/update/{id}")
    ResponseEntity updateCar(@PathVariable Long id, @RequestBody CarDto carDto);

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteCar(@PathVariable Long id);
}
