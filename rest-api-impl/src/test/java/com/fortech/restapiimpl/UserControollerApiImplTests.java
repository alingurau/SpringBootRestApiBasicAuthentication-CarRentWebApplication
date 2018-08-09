package com.fortech.restapiimpl;

import com.fortech.model.dto.CarDto;
import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.UserEntity;
import com.fortech.serviceapi.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControollerApiImplTests {

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
        userDto.setUsername("alin02");
        userDto.setPassword("root");

        ResponseEntity result = userControllerImpl.addUser(userDto);

        ResponseEntity expect = new ResponseEntity("USER SAVED", HttpStatus.CREATED);
        assertEquals(result, expect);
    }

    @Test
    public void saveUser_ShouldReturnHttpStatusBadRequest() {
        UserDto userDto;

        ResponseEntity result = userControllerImpl.addUser(null);

        ResponseEntity expect = new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }

    @Test
    public void updateUser_ShouldReturnHttpStatusOK() {
        UserEntity userEntity = new UserEntity();
        UserDto userDto = new UserDto();
        when(userServiceMock.existIdInDatabase(userEntity.getId())).thenReturn(true);

        ResponseEntity result = userControllerImpl.updateUser(userEntity.getId(), userDto);

        ResponseEntity expect = new ResponseEntity<>("USER UPDATED", HttpStatus.OK);
        assertEquals(result, expect);
    }

    @Test
    public void updateUser_ShouldReturnHttpStatusBadRequest() {
        UserEntity userEntity = new UserEntity();
        UserDto userDto = new UserDto();

        ResponseEntity result = userControllerImpl.updateUser(userEntity.getId(), userDto);

        ResponseEntity expect = new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }

    @Test
    public void deleteUser_ShouldReturnHttpStatusOK() {
        UserEntity userEntity = new UserEntity();

        when(userServiceMock.existIdInDatabase(userEntity.getId())).thenReturn(true);
        ResponseEntity result = userControllerImpl.deleteUserById(userEntity.getId());

        ResponseEntity expect = new ResponseEntity("USER DELETED", HttpStatus.OK);
        assertEquals(result, expect);
    }

    @Test
    public void deleteUser_ShouldReturnHttpStatusBadRequest(){
        UserEntity userEntity = new UserEntity();
        when(userServiceMock.existIdInDatabase(userEntity.getId())).thenReturn(false);

        ResponseEntity result = userControllerImpl.deleteUserById(userEntity.getId());

        ResponseEntity expect = new ResponseEntity("BAD REQUEST", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }
}
