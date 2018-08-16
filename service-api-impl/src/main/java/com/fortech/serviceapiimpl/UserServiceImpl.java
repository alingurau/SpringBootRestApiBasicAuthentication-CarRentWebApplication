package com.fortech.serviceapiimpl;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.User;
import com.fortech.model.repositories.UserRepository;
import com.fortech.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public  class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean existIdInDatabase(Long userId) {
        return userRepository.findById(userId).isPresent();
    }

    @Override
    public List<UserDto> readAllUsersDto() {
        List<UserDto> user = new ArrayList<>();
        userRepository.findAll().forEach((users) -> {
            user.add(users.translateToUserDto());
        });
        return user;
    }


    @Override
    public void updateUser(Long userId, UserDto userDto) {
        userRepository.findById(userId);
        User user = new User();
        user.translateToUserDto();
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findAll().forEach(user -> {
            userRepository.deleteById(userId);
        });

    }


    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.translateToUserDto();
        userRepository.save(user);
    }



//    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
//        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
//        for (Role role : userRoles) {
//            roles.add(new SimpleGrantedAuthority(role.getRole()));
//        }
//
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
//        return grantedAuthorities;
//    }

//    private UserDetails buildUserForAuthentication(UserDto userDto, List<GrantedAuthority> authorities) {
//        return new org.springframework.security.core.userdetails.User(userDto.getEmail(), userDto.getPassword(), true, true, authorities);
// }






//    public User findByEmail(String email){
//        return userRepository.findByEmail(email);
//    }
//
//    public User save(UserDto registration){
//        User user = new User();
//        user.setFirstName(registration.getFirstName());
//        user.setLastName(registration.getLastName());
//        user.setEmail(registration.getEmail());
//        user.setPassword(passwordEncoder.encode(registration.getPassword()));
//        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
//        return userRepository.save(user);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email);
//        if (user == null){
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),
//                user.getPassword(),
//                mapRolesToAuthorities(user.getRoles()));
//    }
//
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//    }
}
