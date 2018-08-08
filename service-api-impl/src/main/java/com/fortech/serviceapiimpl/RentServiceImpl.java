package com.fortech.serviceapiimpl;

import com.fortech.model.dto.RentDto;
import com.fortech.model.entities.RentEntity;
import com.fortech.model.repositories.RentRepository;
import com.fortech.serviceapi.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository rentRepository;

    @Override
    public List<RentDto> readAllRentsDto() {
        return rentRepository.findAll()
                .stream()
                .map(RentEntity::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveRent(RentDto rentDto) {
        RentEntity rentEntity=new RentEntity();
        rentEntity.update(rentDto);
        rentRepository.save(rentEntity);
    }

    @Override
    public void updateRent(Long rentId, RentDto rentDto) {
        rentRepository.findById(rentId);
        RentEntity rentEntity = new RentEntity();
        rentEntity.update(rentDto);
        rentRepository.save(rentEntity);
    }

    @Override
    public void deleteRent(Long rentId) {

    }
}
