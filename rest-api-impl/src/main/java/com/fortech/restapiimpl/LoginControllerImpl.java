package com.fortech.restapiimpl;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.UserEntity;
import com.fortech.restapi.LoginController;
import com.fortech.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginControllerImpl implements LoginController {

    @Autowired
    private UserService userService;

    @Override
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @Override
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        UserDto userDto = new UserDto();
        modelAndView.addObject("user", userDto);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @Override
    public ModelAndView createNewUser(@Valid UserEntity userEntity
            , BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity userExists = userService.findUserByEmail(userEntity.toDto().getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(userEntity.toDto());
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new UserEntity());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @Override
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity= userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + userEntity.toDto().getFirstName() + " " + userEntity.toDto().getLastName()
                + " (" + userEntity.toDto().getEmail() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

}

