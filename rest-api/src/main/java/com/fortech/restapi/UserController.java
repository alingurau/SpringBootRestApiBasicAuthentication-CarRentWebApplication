package com.fortech.restapi;

import com.fortech.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/users")
public interface UserController {

    @GetMapping("/readAll")
    List <UserDto> readAllUsers();

    @PostMapping("/addUser")
    ResponseEntity addUser(@RequestBody UserDto userDto);

    @PutMapping("/updateUser/{userId}")
    ResponseEntity updateUser(@PathVariable Long userId, @RequestBody UserDto userDto);

    @DeleteMapping("/deleteUser/{userId}")
    ResponseEntity deleteUserById(@PathVariable Long userId);
}
