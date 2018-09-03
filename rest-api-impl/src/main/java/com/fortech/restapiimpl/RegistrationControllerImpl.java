//package com.fortech.restapiimpl;
//
//import com.fortech.model.dto.UserDto;
//import com.fortech.model.entities.User;
//
//import com.fortech.restapi.RegistrationController;
//import com.fortech.serviceapi.RegistrationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//
//@RestController
//public class RegistrationControllerImpl implements RegistrationController {
//
//    @Autowired
//    RegistrationService registrationService;
//
//    @Override
//    public ModelAndView login() {
//        ModelAndView model = new ModelAndView();
//
//        model.setViewName("user/login");
//        return model;    }
//
//    @Override
//    public ModelAndView signup() {
//        ModelAndView model = new ModelAndView();
//        UserDto userDto = new UserDto();
//        model.addObject("user", userDto);
//        model.setViewName("user/signup");
//
//        return model;    }
//
//    @Override
//    public ModelAndView createUser(@Valid User userEntity, BindingResult bindingResult) {
//        ModelAndView model = new ModelAndView();
//        User userExists = registrationService.findByEmail(userEntity.translateToUserDto().getEmail());
//
//        if(userExists != null) {
//            bindingResult.rejectValue("email", "error.user", "This email already exists!");
//        }
//        if(bindingResult.hasErrors()) {
//            model.setViewName("user/signup");
//        } else {
//            registrationService.saveUser(userEntity);
//            model.addObject("msg", "User has been registered successfully!");
//            model.addObject("user", new User());
//            model.setViewName("user/signup");
//        }
//
//        return model;    }
//
//    @Override
//    public ModelAndView home() {
//        ModelAndView model = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User userEntity = registrationService.findByEmail(auth.getName());
//
//        model.addObject("userName", userEntity.getFirstname() + " " + userEntity.getLastname());
//        model.setViewName("home/home");
//        return model;    }
//
//    @Override
//    public ModelAndView accessDenied() {
//
//        ModelAndView model = new ModelAndView();
//        model.setViewName("errors/access_denied");
//        return model;
//    }
//
//    @Override
//    public ModelAndView welcome() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("frontPage/welcome");
//        return model;
//    }
//













//
//    @Autowired
//     UserService userService;
//
//    @Override
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }
//
//    @Override
//    public ModelAndView registration(){
//        ModelAndView modelAndView = new ModelAndView();
//        UserDto userDto = new UserDto();
//        modelAndView.addObject("user", userDto);
//        modelAndView.setViewName("registration");
//        return modelAndView;
//    }
//
//
//    @Override
//    public ModelAndView createNewUser(@Valid UserDto userDto, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findByEmail(userDto.getEmail());
//        if (userExists != null) {
//            bindingResult
//                    .rejectValue("email", "error.user",
//                            "There is already a user registered with the email provided");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("registration");
//        } else {
//            userService.saveUser(userDto);
//            modelAndView.addObject("successMessage", "User has been registered successfully");
//            modelAndView.addObject("user", new UserDto());
//            modelAndView.setViewName("registration");
//
//        }
//        return modelAndView;
//    }
//
//
//    @Override
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findByEmail(auth.getName());
//        modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
//        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
//        modelAndView.setViewName("admin/home");
//        return modelAndView;
//    }
//
//}

