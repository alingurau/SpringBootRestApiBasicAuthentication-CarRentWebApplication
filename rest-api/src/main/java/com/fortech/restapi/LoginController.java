package com.fortech.restapi;

import com.fortech.model.dto.UserDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public interface LoginController {

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
     ModelAndView login();

    @RequestMapping(value="/registration", method = RequestMethod.GET)
     ModelAndView registration();

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    ModelAndView createNewUser(@Valid UserDto userDto, BindingResult bindingResult);

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
        ModelAndView home();
}
