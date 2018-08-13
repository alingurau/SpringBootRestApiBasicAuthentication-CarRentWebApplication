package com.fortech.restapiimpl;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.UserEntity;
import com.fortech.restapi.UserController;
import com.fortech.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Override
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();

        model.setViewName("user/login");
        return model;    }

    @Override
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        UserDto userDto = new UserDto();
        model.addObject("user", userDto);
        model.setViewName("user/signup");

        return model;    }

    @Override
    public ModelAndView createUser(@Valid UserEntity userEntity, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        UserEntity userExists = userService.findUserByEmail(userEntity.toDto().getEmail());

        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("user/signup");
        } else {
            userService.saveUser(userEntity.toDto());
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new UserEntity());
            model.setViewName("user/signup");
        }

        return model;    }

    @Override
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = userService.findUserByEmail(auth.getName());

        model.addObject("userName", userEntity.getFirstName() + " " + userEntity.getLastName());
        model.setViewName("home/home");
        return model;    }

    @Override
    public ModelAndView accessDenied() {

            ModelAndView model = new ModelAndView();
            model.setViewName("errors/access_denied");
            return model;
        }

//    @Override
//    public List<UserDto> readAllUsers() {
//        return userService.readAllUsersDto();
//    }
//
//    @Override
//    public ResponseEntity addUser(UserDto userDto) {
//        if (userDto != null) {
//            userService.saveUser(userDto);
//            return new ResponseEntity<String>("USER SAVED", HttpStatus.CREATED);
//        }
//        return new ResponseEntity<String>("INVALID INPUT", HttpStatus.BAD_REQUEST);
//    }
//
//    @Override
//    public ResponseEntity updateUser(Long userId, UserDto updateUser) {
//        if (userService.existIdInDatabase(userId)) {
//            userService.updateUser(userId, updateUser);
//            return new ResponseEntity<>("USER UPDATED", HttpStatus.OK);
//        }
//        return new ResponseEntity<String>("INVALID INPUT", HttpStatus.BAD_REQUEST);
//    }
//
//    @Override
//    public ResponseEntity deleteUser(Long userId) {
//        if (userService.existIdInDatabase(userId)) {
//            userService.deleteUser(userId);
//            return new ResponseEntity("USER DELETED", HttpStatus.OK);
//        }
//        return new ResponseEntity("BAD REQUEST", HttpStatus.BAD_REQUEST);
//
//    }
}
