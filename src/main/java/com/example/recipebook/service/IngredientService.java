package com.example.recipebook.service;

import com.example.recipebook.exception.ResourceNotFoundException;
import com.example.recipebook.model.Ingredient;
import com.example.recipebook.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

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
	
	public Ingredient createIngredient(Ingredient ingredient) {
		return repository.save(ingredient);
	}

	public Ingredient updateIngredient(Long id, Ingredient ingredient) {
		return repository.findById(id).map(ing -> {
			ing.setName(ingredient.getName());
			ing.setReciepes(ingredient.getReciepes());
			return repository.save(ing);
		}).orElseThrow(() -> new ResourceNotFoundException("IngredientId " + id + " not found"));
	}

	public ResponseEntity deleteIngredient(Long id) {
		return repository.findById(id).map(ingredient -> {
			repository.delete(ingredient);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("IngredientId " + id + " not found"));
	}

}
