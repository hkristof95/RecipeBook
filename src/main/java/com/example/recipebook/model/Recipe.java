package com.example.recipebook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "recipe")
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String name;

	private String description;

	@ManyToMany(mappedBy = "recipes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Ingredient> ingredients;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn
	private List<Restaurant> restaurants;

	public Recipe() {

	}

	public Recipe(String name, String description , List<Ingredient> ingredients,
			List<Restaurant> restaurants) {
		super();
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.restaurants = restaurants;
	}

	public Recipe(Long id, String name, String description , List<Ingredient> ingredients,
			List<Restaurant> restaurants) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.restaurants = restaurants;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", ingredients=" + ingredients +
				", restaurants=" + restaurants + "]";
	}
	
}
