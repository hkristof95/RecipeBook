package com.example.recipebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.recipebook.model.Restaurant;
import com.example.recipebook.service.RestaurantService;

@RestController
@RequestMapping("/recipebook/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService service;

    @GetMapping("/all")
    public List<Restaurant> all() {
        return service.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable("id") Long id) {
        return service.getRestaurantById(id);
    }

    @GetMapping("/name/{name}")
    public Restaurant findByName(@PathVariable("name") String name) { return service.findByName(name); }

    @PostMapping("")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return service.createRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id ,@RequestBody Restaurant restaurant) {
        return service.updateRestaurant(id, restaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable Long id) {
        return service.deleteRestaurant(id);
    }
}
