package com.example.recipebook.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public void updateRestaurant(Restaurant restaurant) {
		repository.save(restaurant);
	}
	
	public void addRestaurant(Restaurant restaurant) {
		repository.save(restaurant);
	}
	
}
