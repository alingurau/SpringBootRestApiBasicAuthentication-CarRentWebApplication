package com.fortech.restapi;

import com.fortech.model.dto.UserDto;
import com.fortech.model.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/user")
public interface UserController {

    @PostMapping("/add")
    ResponseEntity addUser(@RequestBody User user);

    @RequestMapping("/get{id}")
    ResponseEntity getUser(@PathVariable Long id);

    @PutMapping("/update{id}")
    ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserDto userDto);

    @DeleteMapping("/delete{id}")
    ResponseEntity deleteUser(@PathVariable Long id);
}
