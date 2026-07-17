package com.cognizant.springmockito.controller;

import com.cognizant.springmockito.entity.User;
import com.cognizant.springmockito.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {

        return ResponseEntity.ok(userService.getUserById(id));

    }

}