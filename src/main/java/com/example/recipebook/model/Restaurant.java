package com.example.recipebook.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity( name = "restaurant")
@Table
public class Restaurant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String address;

	private String discription;

	private String phonenumber;
	
	@ManyToMany(mappedBy = "restaurants", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Recipe> recipes;

	public Restaurant() {

	}

	public Restaurant(String name, String address, String discription, String phonenumber,
			List<Recipe> recipes) {
		super();
		this.name = name;
		this.address = address;
		this.discription = discription;
		this.phonenumber = phonenumber;
		this.recipes = recipes;
	}

	public Restaurant(Long id, String name, String address, String discription, String phonenumber,
			List<Recipe> recipes) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.discription = discription;
		this.phonenumber = phonenumber;
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

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", discription=" + discription
				+ ", phonenumber=" + phonenumber + ", recipes=" + recipes + "]";
	}
	
}
