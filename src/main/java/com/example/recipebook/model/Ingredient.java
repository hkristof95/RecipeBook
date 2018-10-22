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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Ingredient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinColumn
//	private List<Recipe> reciepes;

	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ingredient(String name/*, List<Recipe> reciepes*/) {
		super();
		this.name = name;
//		this.reciepes = reciepes;
	}

	public Ingredient(Long id, String name/*, List<Recipe> reciepes*/) {
		super();
		this.id = id;
		this.name = name;
//		this.reciepes = reciepes;
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

//	public List<Recipe> getReciepes() {
//		return reciepes;
//	}
//
//	public void setReciepes(List<Recipe> reciepes) {
//		this.reciepes = reciepes;
//	}
//
//	@Override
//	public String toString() {
//		return "Ingredient [id=" + id + ", name=" + name + ", reciepes=" + reciepes + "]";
//	}
	
}
