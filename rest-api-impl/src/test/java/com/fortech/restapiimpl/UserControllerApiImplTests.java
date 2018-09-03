package com.fortech.restapiimpl;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.User;
import com.fortech.serviceapi.UserService;
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
public class UserControllerApiImplTests {

    @InjectMocks
    UserControllerImpl userControllerImpl;
    @Mock
    UserService userServiceMock;

    @Test
    public void saveUser_ShouldReturnHttpStatusOK() {
        UserDto userDto = new UserDto();
        userDto.setFirstName("Alin");
        userDto.setLastName("Gurau");
        userDto.setEmail("alin.gurau@email.com");
        userDto.setPassword("root");

        ResponseEntity result = userControllerImpl.addUser(userDto);

        ResponseEntity expect = new ResponseEntity("USER SAVED", HttpStatus.CREATED);
        assertEquals(result, expect);
    }

    @Test
    public void saveUser_ShouldReturnHttpStatusBadRequest() {


        ResponseEntity result = userControllerImpl.addUser(null);

        ResponseEntity expect = new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }

    @Test
    public void updateUser_ShouldReturnHttpStatusOK() {
        User user = new User();
        UserDto userDto = new UserDto();
        when(userServiceMock.ifUserIdExistsInDatabase(user.getId())).thenReturn(true);

        ResponseEntity result = userControllerImpl.updateUser(user.getId(), userDto);

        ResponseEntity expect = new ResponseEntity<>("USER UPDATED", HttpStatus.OK);
        assertEquals(result, expect);
    }

    @Test
    public void updateUser_ShouldReturnHttpStatusBadRequest() {
        User user = new User();
        UserDto userDto = new UserDto();

        ResponseEntity result = userControllerImpl.updateUser(user.getId(), userDto);

        ResponseEntity expect = new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }

    @Test
    public void deleteUser_ShouldReturnHttpStatusOK() {
        User user = new User();

        when(userServiceMock.ifUserIdExistsInDatabase(user.getId())).thenReturn(true);
        ResponseEntity result = userControllerImpl.deleteUserById(user.getId());

        ResponseEntity expect = new ResponseEntity("USER DELETED", HttpStatus.OK);
        assertEquals(result, expect);
    }

    @Test
    public void deleteUser_ShouldReturnHttpStatusBadRequest(){
        User user = new User();
        when(userServiceMock.ifUserIdExistsInDatabase(user.getId())).thenReturn(false);

        ResponseEntity result = userControllerImpl.deleteUserById(user.getId());

        ResponseEntity expect = new ResponseEntity("BAD REQUEST", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }
}
