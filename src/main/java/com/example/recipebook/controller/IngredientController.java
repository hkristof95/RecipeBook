package com.example.recipebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipebook.model.Ingredient;
import com.example.recipebook.service.IngredientService;

@RestController
@RequestMapping("/recipebook/ingredients")
public class IngredientController {

	@Autowired
	private IngredientService service;

    @GetMapping("/all")
    public List<Ingredient> all() {
        return service.getAllIngredients();
    }
    
    @GetMapping("/{id}")
    public Ingredient ingredient(@PathVariable("id") Long id) {
        return service.getIngredientById(id);
    }
    
    @PutMapping("/{id")
    public void updateIngredient(@RequestBody Ingredient ingredient) {
    	service.updateIngredient(ingredient);
    }
    
}
