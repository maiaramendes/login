package com.login.user.controller;

import com.login.exceptions.UserNotFoundException;
import com.login.user.model.User;
import com.login.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userName}/detail")
    public ResponseEntity<User> getUserDetail(@PathVariable final String userName) throws UserNotFoundException {
        return ResponseEntity.ok(userService.find(userName));
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }
}
