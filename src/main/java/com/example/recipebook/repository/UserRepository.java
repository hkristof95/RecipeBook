package com.example.recipebook.repository;

import com.example.recipebook.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

    Optional<User> findByName(String name);
}
