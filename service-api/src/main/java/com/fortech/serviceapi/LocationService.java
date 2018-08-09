package com.fortech.serviceapi;

import com.fortech.model.dto.LocationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {

    List<LocationDto> readAllLocationsDto();

    void saveLocation(LocationDto locationDto);

    void updateLocation(Long locationId, LocationDto locationDto);

    void deleteLocation(Long locationId);

    boolean locationIdExistsInDatabase(Long locationId);
}
