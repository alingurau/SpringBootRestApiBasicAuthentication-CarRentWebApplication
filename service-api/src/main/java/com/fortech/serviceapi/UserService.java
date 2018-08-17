package com.fortech.serviceapi;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService  {

    List<UserDto> readAllUsersDto();

    void saveUser(UserDto userDto);

    void  updateUser(Long userId, UserDto userDto);

    void deleteUser(Long userId);

    boolean ifUserIdExistsInDatabase(Long userId);
}
