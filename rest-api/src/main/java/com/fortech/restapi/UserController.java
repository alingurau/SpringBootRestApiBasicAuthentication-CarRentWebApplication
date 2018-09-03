package com.fortech.restapi;

import com.fortech.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public interface UserController {

    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
    ModelAndView editUser();

    @PostMapping("/addUser")
    ResponseEntity addUser(@RequestBody UserDto user);

    @PutMapping("/updateUser/{userId}")
    ResponseEntity updateUser(@PathVariable Long userId, @RequestBody UserDto userDto);

    @DeleteMapping("/deleteUser/{userId}")
    ResponseEntity deleteUserById(@PathVariable Long userId);
}
