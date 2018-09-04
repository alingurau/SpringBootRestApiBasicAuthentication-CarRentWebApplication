package com.fortech.serviceapiimpl;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.Role;
import com.fortech.model.entities.User;
import com.fortech.model.repositories.RoleRepository;
import com.fortech.model.repositories.UserRepository;
import com.fortech.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

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
        if (userRepository.findAll().isEmpty()) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setActive(true);
            Role userRole = roleRepository.findByRole("ADMIN");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            userRepository.save(user);
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setActive(true);
            Role userRoleClient = roleRepository.findByRole("CLIENT");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRoleClient)));
            userRepository.save(user);
        }
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

    @Override
    public boolean userIdExists(Long userId) {
        return userRepository.findById(userId).isPresent();
    }


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
