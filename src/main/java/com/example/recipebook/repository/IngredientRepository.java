package com.example.recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recipebook.model.Ingredient;

@Repository
public interface IngredientRepository  extends JpaRepository<Ingredient, Long> {

}
