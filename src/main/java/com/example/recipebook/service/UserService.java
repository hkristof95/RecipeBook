package com.example.recipebook.service;

import com.example.recipebook.enums.Role;
import com.example.recipebook.exception.ResourceNotFoundException;
import com.example.recipebook.model.User;
import com.example.recipebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public class UserService implements Serializable {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    public Iterable<User> getAllUser() { return repository.findAll(); }

    public Optional<User> getUser(Integer id) { return repository.findById(id); }

    public ResponseEntity<User> registration(User user) {
        Optional<User> oUser = repository.findByName(user.getName());
        if (oUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        return ResponseEntity.ok(repository.save(user));
    }

    public User updateUser(Integer id, User user) {
        return repository.findById(id).map(us -> {
            us.setAddress(user.getAddress());
            us.setEmail(user.getEmail());
            us.setName(user.getName());
            us.setPhoneNumber(user.getPhoneNumber());
            us.setRestaurants(user.getRestaurants());
            us.setPassword(passwordEncoder.encode(user.getPassword()));
            return repository.save(us);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + id + " not found"));
    }


    public ResponseEntity deleteUser(Integer id) {
        return repository.findById(id).map(user -> {
            repository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + id + " not found"));
    }
}
