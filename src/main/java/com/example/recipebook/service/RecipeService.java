package com.example.recipebook.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipebook.model.Ingredient;
import com.example.recipebook.model.Recipe;
import com.example.recipebook.repository.RecipeRepository;
import com.example.recipebook.repository.RestaurantRepository;

@Service
public class RecipeService implements Serializable {

	@Autowired
	private RecipeRepository repository;

	public List<Recipe> getAllRecipes() {
		return repository.findAll();
	}
	
	public Recipe getRecipeById(Long id) {
		return repository.findById(id).get();
	}
	
	public void updateRecipe(Recipe recipe) {
		repository.save(recipe);
	}
	
	public void addRecipe(Recipe recipe) {
		repository.save(recipe);
	}
}
