package com.fortech.restapi;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public interface RegistrationController {

    @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
    ModelAndView login();

    @RequestMapping(value= {"signup"}, method=RequestMethod.GET)
    ModelAndView signup();

    @RequestMapping(value= {"signup"}, method=RequestMethod.POST)
    ModelAndView createUser(@Valid User user, BindingResult bindingResult);

    @RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
    ModelAndView home();

    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
    ModelAndView accessDenied();

    @RequestMapping(value={"/welcome"}, method = RequestMethod.GET)
     ModelAndView welcome();

//    @RequestMapping(value="/registration", method = RequestMethod.GET)
//     ModelAndView registration();
//
//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    ModelAndView createNewUser(@Valid UserDto userDto, BindingResult bindingResult);
//
//    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
//        ModelAndView home();
}
