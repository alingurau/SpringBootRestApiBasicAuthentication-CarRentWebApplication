package com.fortech.restapi;

import com.fortech.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/users")
public interface UserController {

    @GetMapping("/readAll")
    List<UserDto> readAllUsers();

    @PostMapping("/addUser")
    ResponseEntity addUser(@RequestBody UserDto user);

    @PutMapping("/updateUser/{userId}")
    ResponseEntity updateUser(@PathVariable Long userId, @RequestBody UserDto userDto);

    @DeleteMapping("/deleteUser/{userId}")
    ResponseEntity deleteUserById(@PathVariable Long userId);
}
