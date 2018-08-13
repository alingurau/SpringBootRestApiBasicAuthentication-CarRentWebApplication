package com.fortech.serviceapiimpl;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.RoleEntity;
import com.fortech.model.entities.UserEntity;
import com.fortech.model.repositories.RoleRepository;
import com.fortech.model.repositories.UserRepository;
import com.fortech.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
     private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.update(userDto);

        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        RoleEntity userRole = roleRepository.findByRole("ADMIN");
        userDto.setRoleName(new HashSet<RoleEntity>(Arrays.asList(userRole)));
        userRepository.save(userEntity);
    }


    @Override
    public List<UserDto> readAllUsersDto() {
        List<UserDto> user = new ArrayList<>();
        userRepository.findAll().forEach((users) -> {
            user.add(users.toDto());
        });
        return user;
    }

//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        UserEntity userEntity = userRepository.findByEmail(userName);
//        List<GrantedAuthority> authorities = getUserAuthority(userEntity.getRoles());
//        return buildUserForAuthentication(userEntity.toDto(), authorities);
//    }

//    private List<GrantedAuthority> getUserAuthority(Set<RoleEntity> userRoles) {
//        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
//        for (RoleEntity role : userRoles) {
//            roles.add(new SimpleGrantedAuthority(role.getRole()));
//        }
//
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
//        return grantedAuthorities;
//    }

//    private UserDetails buildUserForAuthentication(UserDto userDto, List<GrantedAuthority> authorities) {
//        return new org.springframework.security.core.userdetails.User(userDto.getEmail(), userDto.getPassword(), true, true, authorities);
//    }

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
