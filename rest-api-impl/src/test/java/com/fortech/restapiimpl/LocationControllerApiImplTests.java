package com.fortech.restapiimpl;

import com.fortech.model.dto.LocationDto;
import com.fortech.model.entities.LocationEntity;
import com.fortech.serviceapi.LocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LocationControllerApiImplTests {

    @InjectMocks
    LocationControllerImpl locationControllerImpl;

    @Mock
    LocationService locationServiceMock;

    @Test
    public void saveLocation_ShouldReturnHttpStatusOK() {
        LocationDto locationDto = new LocationDto();
        locationDto.setCountry("Italy");
        locationDto.setCity("Rome");
        locationDto.setAddress("Viale Dante 5");
        locationDto.setZipcode("90888");

        ResponseEntity result = locationControllerImpl.saveLocation(locationDto);

        ResponseEntity expect = new ResponseEntity("LOCATION SAVED", HttpStatus.CREATED);
        assertEquals(result, expect);
    }

    @Test
    public void saveLocation_ShouldReturnHttpStatusBadRequest() {
        ResponseEntity result = locationControllerImpl.saveLocation(null);

        ResponseEntity expect = new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }

    @Test
    public void updateLocation_ShouldReturnHttpStatusOK() {
        LocationEntity locationEntity = new LocationEntity();
        LocationDto locationDto = new LocationDto();
        when(locationServiceMock.locationIdExistsInDatabase(locationEntity.getId())).thenReturn(true);

        ResponseEntity result = locationControllerImpl.updateLocation(locationEntity.getId(), locationDto);

        ResponseEntity expect = new ResponseEntity("LOCATION UPDATED", HttpStatus.OK);
        assertEquals(result, expect);
    }

    @Test
    public void updateLocation_ShouldReturnHttpStatusBadRequest() {
        LocationEntity locationEntity = new LocationEntity();
        LocationDto locationDto = new LocationDto();

        ResponseEntity result = locationControllerImpl.updateLocation(locationEntity.getId(), locationDto);

        ResponseEntity expect = new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }

    @Test
    public void deleteLocation_ShouldReturnHttpStatusOK() {
        LocationEntity locationEntity = new LocationEntity();

        when(locationServiceMock.locationIdExistsInDatabase(locationEntity.getId())).thenReturn(true);
        ResponseEntity result = locationControllerImpl.deleteLocation(locationEntity.getId());

        ResponseEntity expect = new ResponseEntity("LOCATION DELETED", HttpStatus.OK);
        assertEquals(result, expect);
    }

    @Test
    public void deleteLocation_ShouldReturnHttpStatusBadRequest() {
        LocationEntity locationEntity = new LocationEntity();
        when(locationServiceMock.locationIdExistsInDatabase(locationEntity.getId())).thenReturn(false);

        ResponseEntity result = locationControllerImpl.deleteLocation(locationEntity.getId());

        ResponseEntity expect = new ResponseEntity("BAD REQUEST", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }
}
