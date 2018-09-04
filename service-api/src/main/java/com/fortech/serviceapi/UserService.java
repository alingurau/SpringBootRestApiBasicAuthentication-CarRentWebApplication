package com.fortech.serviceapi;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void saveUser(User user);

    User getUser(Long id);

    User updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

    public User findUserByEmail(String email);

    boolean ifUserIdExistsInDatabase(Long userId);
}
