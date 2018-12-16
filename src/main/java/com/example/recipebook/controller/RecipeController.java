package com.example.recipebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Recipe getRecipe(@PathVariable("id") Long id) {
        return service.getRecipeById(id);
    }

    @PostMapping("")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return service.createRecipe(recipe);
    }

    @PutMapping("/{id")
    public Recipe updateRecipe(@PathVariable Long id ,@RequestBody Recipe recipe) {
        return service.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRecipe(@PathVariable Long id) {
        return service.deleteRecipe(id);
    }
    
}
