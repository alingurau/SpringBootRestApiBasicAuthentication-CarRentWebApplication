package com.fortech.serviceapi;

import com.fortech.model.dto.RentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentService {

    List<RentDto> readAllRentsDto();

    void saveRent(RentDto rentDto);

    void  updateRent(Long rentId, RentDto rentDto);

    void deleteRent(Long rentId);
}
