package com.example.recipebook.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String address;

	private String description;

	private String phoneNumber;
	
	@ManyToMany(mappedBy = "restaurants", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Recipe> recipes;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private User user;

	public Restaurant() {

	}

	public Restaurant(String name, String address, String discription, String phonenumber,
			List<Recipe> recipes) {
		super();
		this.name = name;
		this.address = address;
		this.description = discription;
		this.phoneNumber = phonenumber;
		this.recipes = recipes;
	}

	public Restaurant(Long id, String name, String address, String discription, String phonenumber,
			List<Recipe> recipes) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = discription;
		this.phoneNumber = phonenumber;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Restaurant{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", description='" + description + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", recipes=" + recipes +
				", user=" + user +
				'}';
	}
}
