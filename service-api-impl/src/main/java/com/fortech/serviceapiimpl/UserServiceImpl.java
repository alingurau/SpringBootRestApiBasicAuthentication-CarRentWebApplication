package com.fortech.serviceapiimpl;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.RoleEntity;
import com.fortech.model.entities.UserEntity;
import com.fortech.model.repositories.RoleRepository;
import com.fortech.model.repositories.UserRepository;
import com.fortech.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUserWithRole(UserEntity userEntity) {
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        RoleEntity userRole = roleRepository.findByRole("ADMIN");
        userEntity.setRoleName(new HashSet<RoleEntity>(Arrays.asList(userRole)));
        userRepository.save(userEntity).toDto();
    }


    @Override
    public List<UserDto> readAllUsersDto() {
        List<UserDto> user = new ArrayList<>();
        userRepository.findAll().forEach((users) -> {
            user.add(users.toDto());
        });
        return user;
    }

    @Override
    public void saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.update(userDto);
        userRepository.save(userEntity);
    }

    @Override
    public boolean existIdInDatabase(Long userId) {
        return userRepository.findById(userId).isPresent();
    }

    @Override
    public void updateUser(Long userId, UserDto userDto) {
        userRepository.findById(userId);
        UserEntity userEntity = new UserEntity();
        userEntity.update(userDto);
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findAll().forEach(userEntity -> {
            userRepository.deleteById(userId);
        });

    }
}
