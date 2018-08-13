package com.fortech.serviceapi;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public interface UserService {

    UserEntity findUserByEmail(String email);

//    void saveUserWithRole(UserEntity userEntity);

    List<UserDto> readAllUsersDto();

    void saveUser(UserDto userDto);

    void  updateUser(Long userId, UserDto userDto);

    void deleteUser(Long userId);

//    @Transactional
//    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;

    boolean existIdInDatabase(Long userId);

}
