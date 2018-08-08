package com.fortech.serviceapi;

import com.fortech.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    List<UserDto> readAllUsersDto();

    void saveUser(UserDto userDto);

    boolean existIdInDatabase(Long userId);

    void  updateUser(Long userId, UserDto userDto);

    void deleteUser(Long userId);
}
