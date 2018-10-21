package com.example.recipebook.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipebook.repository.IngredientRepository;
import com.example.recipebook.repository.RestaurantRepository;

import com.example.recipebook.model.Ingredient;
import com.example.recipebook.model.Restaurant;

@Service
public class IngredientService implements Serializable {

	@Autowired
	private IngredientRepository repository;

	public List<Ingredient> getAllIngredients() {
		return repository.findAll();
	}
	
	public Ingredient getIngredientById(Long id) {
		return repository.findById(id).get();
	}
	
	public void updateIngredient(Ingredient ingredient) {
		repository.save(ingredient);
	}
	
	public void addIngredient(Ingredient ingredient) {
		repository.save(ingredient);
	}
	
}
