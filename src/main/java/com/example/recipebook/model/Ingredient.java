package com.example.recipebook.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Ingredient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn
	private List<Recipe> recipes;


	public Ingredient(String name, List<Recipe> recipes) {
		super();
		this.name = name;
		this.recipes = recipes;
	}

	public Ingredient(Long id, String name, List<Recipe> recipes) {
		super();
		this.id = id;
		this.name = name;
		this.recipes = recipes;
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

	public List<Recipe> getReciepes() {
		return recipes;
	}

	public void setReciepes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", recipes=" + recipes + "]";
	}
	
}
