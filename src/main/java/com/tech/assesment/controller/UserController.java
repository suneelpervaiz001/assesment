package com.tech.assesment.controller;

import com.tech.assesment.entity.RetailUser;
import com.tech.assesment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<RetailUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<RetailUser> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public RetailUser createUser(@RequestBody RetailUser user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public RetailUser updateUser(@PathVariable Long id, @RequestBody RetailUser user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
