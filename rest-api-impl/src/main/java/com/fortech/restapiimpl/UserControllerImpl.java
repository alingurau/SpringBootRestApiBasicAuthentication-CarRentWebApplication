package com.fortech.restapiimpl;


import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.User;
import com.fortech.restapi.UserController;
import com.fortech.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity addUser(User user) {
        if (user != null) {
            userService.saveUser(user);
            return new ResponseEntity("User Saved", HttpStatus.CREATED);
        }
        return new ResponseEntity("Invalid input", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity getUser(Long id) {
        if (userService.userIdExists(id)) {
            userService.getUser(id);
            return new ResponseEntity("User get", HttpStatus.OK);
        }
        return new ResponseEntity("Invalid request", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity updateUser(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        return null;
    }

//    @Override
//    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
//    public ModelAndView editUser() {
//        ModelAndView modelAndView = new ModelAndView();
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//
//        User user = userService.findUserByEmail(email);
//
//        modelAndView.addObject("user", user);
//        modelAndView.addObject("title", "Edit my account");
//        modelAndView.addObject("action", "/user/edit");
//        modelAndView.setViewName("registration");
//
//        return modelAndView;
//    }
//

//    @Override
//    public ResponseEntity updateUser(Long userId, UserDto updateUser) {
//        if (userService.ifUserIdExistsInDatabase(userId)) {
//            userService.updateUser(userId, updateUser);
//            return new ResponseEntity<>("USER UPDATED", HttpStatus.OK);
//        }
//        return new ResponseEntity<String>("INVALID INPUT", HttpStatus.BAD_REQUEST);
//    }
//
//    @Override
//    public ResponseEntity deleteUserById(Long userId) {
//        if (userService.ifUserIdExistsInDatabase(userId)) {
//            userService.deleteUser(userId);
//            return new ResponseEntity("USER DELETED", HttpStatus.OK);
//        }
//        return new ResponseEntity("BAD REQUEST", HttpStatus.BAD_REQUEST);
//
//    }
}
