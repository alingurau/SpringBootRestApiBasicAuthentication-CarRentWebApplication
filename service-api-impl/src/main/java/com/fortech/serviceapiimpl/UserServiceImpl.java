package com.fortech.serviceapiimpl;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.User;
import com.fortech.model.repositories.RoleRepository;
import com.fortech.model.repositories.UserRepository;
import com.fortech.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean userIdExists(Long userId) {
        return userRepository.findById(userId).isPresent();
    }

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
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

//    @Override
//    public List<UserDto> readAllUsersDto() {
//        List<UserDto> user = new ArrayList<>();
//        userRepository.findAll().forEach((users) -> {
//            user.add(users.translateToUserDto());
//        });
//        return user;
//    }


//    @Override
//    public User updateUser(Long userId, UserDto userDto) {
//
//        User user = userRepository.findById(userId).get();
//        user.update(userDto);
//
//        return userRepository.save(user);
//    }
//
//    @Override
//    public void deleteUser(Long userId) {
//        userRepository.findAll().forEach(user -> {
//            userRepository.deleteById(userId);
//        });
//
//    }


//    @Override
//    public void addUser(UserDto userDto) {
//        if(roleRepository.findAll().isEmpty())
//            createRoles();
//
//        User user = new User();
//        user.update(userDto);
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setActive(true);
//        user.setRoles(new HashSet<Role>(Arrays.asList(getRoleForUser())));
//
//        userRepository.save(user);
//    }


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
