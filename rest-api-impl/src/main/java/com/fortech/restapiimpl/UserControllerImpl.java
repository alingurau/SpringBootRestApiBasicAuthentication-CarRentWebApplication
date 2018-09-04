package com.fortech.restapiimpl;


import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.User;
import com.fortech.restapi.UserController;
import com.fortech.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity addUser(User user) {
        if (user != null) {
            userService.saveUser(user);
            return new ResponseEntity("USER SAVED", HttpStatus.CREATED);
        }
        return new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity getUser(Long id) {
        if (userService.userIdExists(id)) {
            userService.getUser(id);
            return new ResponseEntity("USER GET", HttpStatus.OK);
        }
        return new ResponseEntity("INVALID REQUEST", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity updateUser(Long id, UserDto userDto) {
        if (userService.userIdExists(id)) {
            userService.updateUser(id, userDto);
            return new ResponseEntity("USER UPDATED", HttpStatus.OK)
        }
        return new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        return null;
    }
}
