package com.example.recipebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Restaurant ingredient(@PathVariable("id") Long id) {
        return service.getRestaurantById(id);
    }
    
    @PutMapping("/{id")
    public void updateIngredient(@RequestBody Restaurant restaurant) {
    	service.updateRestaurant(restaurant);
    }
    
}
