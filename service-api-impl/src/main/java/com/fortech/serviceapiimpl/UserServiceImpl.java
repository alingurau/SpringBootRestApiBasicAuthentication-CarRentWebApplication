package com.fortech.serviceapiimpl;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.User;
import com.fortech.model.repositories.RoleRepository;
import com.fortech.model.repositories.UserRepository;
import com.fortech.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public User updateUser(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public boolean userIdExists(Long userId) {
        return userRepository.findById(userId).isPresent();
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
