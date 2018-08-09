package com.fortech.restapiimpl;

import com.fortech.model.dto.LocationDto;
import com.fortech.restapi.LocationController;
import com.fortech.serviceapi.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationControllerImpl implements LocationController {

    @Autowired
    LocationService locationService;

    @Override
    public List<LocationDto> readAllLocations() {
        return locationService.readAllLocationsDto();
    }

    @Override
    public ResponseEntity saveLocation(LocationDto locationDto) {
        if (locationDto != null) {
            locationService.saveLocation(locationDto);
            return new ResponseEntity("LOCATION SAVED", HttpStatus.CREATED);
        }
        return new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity updateLocation(Long locationId, LocationDto locationDto) {
        if (locationService.locationIdExistsInDatabase(locationId)) {
            locationService.updateLocation(locationId, locationDto);
            return new ResponseEntity<>("LOCATION UPDATED", HttpStatus.OK);
        }
        return new ResponseEntity<String>("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity deleteLocation(Long locationId) {
        if (locationService.locationIdExistsInDatabase(locationId)) {
            locationService.deleteLocation(locationId);
            return new ResponseEntity("LOCATION DELETED", HttpStatus.OK);
        }
        return new ResponseEntity("BAD REQUEST", HttpStatus.BAD_REQUEST);
    }
}
