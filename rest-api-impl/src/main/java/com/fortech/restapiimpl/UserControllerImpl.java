package com.fortech.restapiimpl;

import com.fortech.model.dto.UserDto;
import com.fortech.restapi.UserController;
import com.fortech.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Override
    public List<UserDto> readAllUsers() {
        return userService.readAllUsersDto();
    }

    @Override
    public ResponseEntity addUser(UserDto userDto) {
        userService.saveUser(userDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity updateUser(Long userId, UserDto userDto) {
        if(userDto != null){
            userService.updateUser(userId, userDto);
            return new ResponseEntity<String>("CAR UPDATED", HttpStatus.OK);
        }
        return new ResponseEntity<String>("INVALID INPUT", HttpStatus.BAD_REQUEST);}

    @Override
    public ResponseEntity deleteUserById(Long userId) {
        if(userService.existIdInDatabase(userId)){
            userService.deleteUser(userId);
            return new ResponseEntity("USER DELETED", HttpStatus.OK);
        }
        return new ResponseEntity("INVALID DATA", HttpStatus.BAD_REQUEST);

    }
}
