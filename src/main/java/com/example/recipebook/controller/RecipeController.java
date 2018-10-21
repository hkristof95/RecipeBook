package com.example.recipebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipebook.model.Recipe;
import com.example.recipebook.service.RecipeService;

@RestController
@RequestMapping("/recipebook/recipes")
public class RecipeController {

	@Autowired
	private RecipeService service;

    @GetMapping("/all")
    public List<Recipe> all() {
        return service.getAllRecipes();
    }
    
    @GetMapping("/{id}")
    public Recipe ingredient(@PathVariable("id") Long id) {
        return service.getRecipeById(id);
    }
    
    @PutMapping("/{id")
    public void updateIngredient(@RequestBody Recipe recipe) {
    	service.updateRecipe(recipe);
    }
    
}
