package com.fortech.restapi;

import com.fortech.model.dto.RentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/rents")
public interface RentController {

    @GetMapping("/readAll")
    ResponseEntity<List<RentDto>> readAllRents();

    @PostMapping("/addRent")
    ResponseEntity addRent(@RequestBody RentDto rentDto);

    @PutMapping("/updateRent/{rentId}")
    ResponseEntity updateCar(@PathVariable Long rentId, @RequestBody RentDto rentDto);

    @DeleteMapping("/deleteRemt/{rentId}")
    ResponseEntity deleteRentById(@PathVariable Long rentId);
}
