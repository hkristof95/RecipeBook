package com.example.recipebook.service;

import java.io.Serializable;
import java.util.List;

import com.example.recipebook.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.recipebook.repository.RestaurantRepository;

import com.example.recipebook.model.Restaurant;

@Service
public class RestaurantService implements Serializable {
 
	@Autowired
	private RestaurantRepository repository;
	
	public List<Restaurant> getAllRestaurants() {
		return repository.findAll();
	}

	public Restaurant getRestaurantById(Long id) {
		return repository.findById(id).get();
	}

	public Restaurant findByName(String name) { return repository.findByName(name); }

	public Restaurant createRestaurant(Restaurant restaurant) {
		return  repository.save(restaurant);
	}

	public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
		return repository.findById(id).map(res -> {
			res.setName(restaurant.getName());
			res.setAddress(restaurant.getAddress());
			res.setDescription(restaurant.getDescription());
			res.setPhoneNumber(restaurant.getPhoneNumber());
			res.setRecipes(restaurant.getRecipes());
			return repository.save(res);
		}).orElseThrow(() -> new ResourceNotFoundException("RestaurantId " + id + " not found"));
	}

	public ResponseEntity deleteRestaurant(Long id) {
		return repository.findById(id).map(post -> {
			repository.delete(post);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("RestaurantId " + id + " not found"));
	}
}
