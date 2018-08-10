package com.fortech.serviceapi;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.UserEntity;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;


@Service
public interface UserService {

    UserEntity findUserByEmail(String email);

    void saveUserWithRole(UserEntity userEntity);

    List<UserDto> readAllUsersDto();

    void saveUser(UserDto userDto);

    boolean existIdInDatabase(Long userId);

    void  updateUser(Long userId, UserDto userDto);

    void deleteUser(Long userId);
}
