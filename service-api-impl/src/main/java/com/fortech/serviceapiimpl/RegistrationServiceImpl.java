//package com.fortech.serviceapiimpl;
//
//import com.fortech.model.entities.Role;
//import com.fortech.model.entities.User;
//import com.fortech.model.repositories.RoleRepository;
//import com.fortech.model.repositories.UserRepository;
//import com.fortech.serviceapi.RegistrationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//@Service
//public class RegistrationServiceImpl implements RegistrationService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    public User findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    @Override
//    public void saveUser(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setActive(2);
//        Role userRole = roleRepository.findByRole("USER");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//        userRepository.save(user);
//    }
//}
