package com.fortech.serviceapiimpl;

import com.fortech.model.dto.LocationDto;
import com.fortech.model.entities.LocationEntity;
import com.fortech.model.repositories.LocationRepository;
import com.fortech.serviceapi.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<LocationDto> readAllLocationsDto() {
        return locationRepository.findAll()
                .stream()
                .map(LocationEntity::locationDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveLocation(LocationDto locationDto) {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.update(locationDto);
        locationRepository.save(locationEntity);
    }

    @Override
    public void updateLocation(Long locationId, LocationDto locationDto) {
        locationRepository.findById(locationId);
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.update(locationDto);
        locationRepository.save(locationEntity);
    }

    @Override
    public void deleteLocation(Long locationId) {
        ;
        locationRepository.findAll().forEach(locationEntity -> {
            locationRepository.deleteById(locationId);
        });
    }

    @Override
    public boolean locationIdExistsInDatabase(Long locationId) {
        return locationRepository.findById(locationId).isPresent();
    }
}
