package com.fortech.restapi;

import com.fortech.model.entities.UserEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path="/users")
public interface UserController {

    @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
    public ModelAndView login();

    @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
    public ModelAndView signup();

    @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
    public ModelAndView createUser(@Valid UserEntity userEntity, BindingResult bindingResult);

    @RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
    public ModelAndView home();

    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
    public ModelAndView accessDenied();

//    @GetMapping("/readAll")
//    List <UserDto> readAllUsers();
//
//    @PostMapping("/addUser")
//    ResponseEntity addUser(@RequestBody UserDto userDto);
//
//    @PutMapping("/updateUser/{userId}")
//    ResponseEntity updateUser(@PathVariable Long userId, @RequestBody UserDto updateUser);
//
//    @DeleteMapping("/deleteUser/{userId}")
//    ResponseEntity deleteUser(@PathVariable Long userId);
}
