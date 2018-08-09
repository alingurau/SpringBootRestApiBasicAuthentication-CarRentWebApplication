package com.fortech.restapi;

import com.fortech.model.dto.LocationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "locations")
public interface LocationController {

    @GetMapping("/readAll")
    List<LocationDto> readAllLocations();

    @PostMapping("/addLocation")
    ResponseEntity saveLocation(@RequestBody LocationDto locationDto);

    @PutMapping("/updateLocation/{locationId}")
    ResponseEntity updateLocation(@PathVariable Long locationId, @RequestBody LocationDto locationDto);

    @DeleteMapping("/deleteLocation/{locationId}")
    ResponseEntity deleteLocation(@PathVariable Long locationId);
}
