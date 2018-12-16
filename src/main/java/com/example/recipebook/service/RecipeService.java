package com.example.recipebook.service;

import java.io.Serializable;
import java.util.List;

import com.example.recipebook.exception.ResourceNotFoundException;
import com.example.recipebook.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	public Recipe createRecipe(Recipe recipe) {
		return repository.save(recipe);
	}

	public Recipe updateRecipe(Long id, Recipe recipe) {
		return repository.findById(id).map(rec -> {
			rec.setDescription(recipe.getDescription());
			rec.setIngredients(recipe.getIngredients());
			rec.setName(recipe.getName());
			rec.setRestaurants(recipe.getRestaurants());
			return repository.save(rec);
		}).orElseThrow(() -> new ResourceNotFoundException("RecipeId " + id + " not found"));
	}

	public ResponseEntity deleteRecipe(Long id) {
		return repository.findById(id).map(recipe -> {
			repository.delete(recipe);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("RecipeId " + id + " not found"));
	}
}
