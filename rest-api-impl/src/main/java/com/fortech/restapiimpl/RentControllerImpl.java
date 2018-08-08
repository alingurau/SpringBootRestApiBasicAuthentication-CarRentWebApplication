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
    public ResponseEntity<List<RentDto>> readAllRents() {
        return new ResponseEntity<>(rentService.readAllRentsDto(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity addRent(RentDto rentDto) {
        rentService.saveRent(rentDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity updateCar(Long rentId, RentDto rentDto) {
        if(rentDto != null){
            rentService.updateRent(rentId, rentDto);
            return new ResponseEntity<String>("RENT UPDATED", HttpStatus.OK);
        }
        return new ResponseEntity<String>("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity deleteRentById(Long rentId) {
        if(rentId != null){
            rentService.deleteRent(rentId);
        }
        return new ResponseEntity("RENT DELETED", HttpStatus.OK);
    }
}
