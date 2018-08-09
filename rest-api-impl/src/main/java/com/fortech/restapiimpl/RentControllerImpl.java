package com.fortech.restapiimpl;

import com.fortech.model.dto.RentDto;
import com.fortech.restapi.RentController;
import com.fortech.serviceapi.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RentControllerImpl implements RentController {

    @Autowired
    RentService rentService;

    @Override
    public List<RentDto> readAllRents() {
        return rentService.readAllRentsDto();
    }

    @Override
    public ResponseEntity addRent(RentDto rentDto) {
        if(rentDto != null){
        rentService.saveRent(rentDto);
        return new ResponseEntity<>("RENT SAVED", HttpStatus.CREATED);
    }
    return new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity updateRent(Long rentId, RentDto rentDto) {
        if(rentId != null){
            rentService.updateRent(rentId, rentDto);
            return new ResponseEntity("RENT UPDATED", HttpStatus.OK);
        }
        return new ResponseEntity<String>("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity deleteRentById(Long rentId) {
        if(rentId != null){
            rentService.deleteRent(rentId);
            return new ResponseEntity("RENT DELETED", HttpStatus.OK);

        }
        return new ResponseEntity("BAD REQUEST", HttpStatus.BAD_REQUEST);
    }
}
