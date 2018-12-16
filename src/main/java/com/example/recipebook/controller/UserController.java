package com.example.recipebook.controller;

import com.example.recipebook.model.User;
import com.example.recipebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @Secured({"ROLE_ADMIN"})
    @GetMapping("")
    public Iterable<User> getAll() {
        return service.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Integer id) {
        return service.getUser(id);
    }

    @PostMapping("/registration")
    public ResponseEntity<User> registration(@RequestBody User user) {
        return service.registration(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        return service.deleteUser(id);
    }
}
