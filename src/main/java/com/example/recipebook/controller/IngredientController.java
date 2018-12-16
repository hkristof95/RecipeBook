package com.example.recipebook.controller;

import com.example.recipebook.model.Ingredient;
import com.example.recipebook.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("")
    public Ingredient createIngredient(Ingredient ingredient) {return service.createIngredient(ingredient);}

    @PutMapping("/{id")
    public void updateIngredient(@PathVariable("id") Long id, @RequestBody Ingredient ingredient) {
    	service.updateIngredient(id, ingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteIngredient(@PathVariable Long id) {
        return service.deleteIngredient(id);
    }
}
