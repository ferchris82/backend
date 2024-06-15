package com.chrisferdev.ecommerce.backend.infrastructure.rest;

import org.springframework.web.bind.annotation.*;

import com.chrisferdev.ecommerce.backend.application.UserService;
import com.chrisferdev.ecommerce.backend.domain.model.User;

@RestController
//http://localhost:8085
@RequestMapping("/api/v1/users")
//http://localhost:8085/api/v1/users
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    //http://localhost:8085/api/v1/users/4
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }
}