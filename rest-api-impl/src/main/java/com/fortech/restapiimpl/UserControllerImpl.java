package com.fortech.restapiimpl;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.User;
import com.fortech.restapi.UserController;
import com.fortech.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Override
    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
    public ModelAndView editUser() {
        ModelAndView modelAndView = new ModelAndView();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userService.findUserByEmail(email);

        modelAndView.addObject("user", user);
        modelAndView.addObject("title", "Edit my account");
        modelAndView.addObject("action", "/user/edit");
        modelAndView.setViewName("registration");

        return modelAndView;
    }

    @Override
    public ResponseEntity addUser(UserDto user) {
        return null;
    }

//    @Override
//    public ResponseEntity addUser(User user) {
//        if (user != null) {
//            userService.saveUser(user);
//            return new ResponseEntity<String>("USER SAVED", HttpStatus.CREATED);
//        }
//        return new ResponseEntity<String>("INVALID INPUT", HttpStatus.BAD_REQUEST);
//    }

    @Override
    public ResponseEntity updateUser(Long userId, UserDto updateUser) {
        if (userService.ifUserIdExistsInDatabase(userId)) {
            userService.updateUser(userId, updateUser);
            return new ResponseEntity<>("USER UPDATED", HttpStatus.OK);
        }
        return new ResponseEntity<String>("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity deleteUserById(Long userId) {
        if (userService.ifUserIdExistsInDatabase(userId)) {
            userService.deleteUser(userId);
            return new ResponseEntity("USER DELETED", HttpStatus.OK);
        }
        return new ResponseEntity("BAD REQUEST", HttpStatus.BAD_REQUEST);

    }
}
