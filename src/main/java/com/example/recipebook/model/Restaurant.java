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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Restaurant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	private String discription;
	private String phonenumber;
	
	@ManyToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Recipe> reciepes;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String name, String address, String discription, String phonenumber,
			List<Recipe> reciepes) {
		super();
		this.name = name;
		this.address = address;
		this.discription = discription;
		this.phonenumber = phonenumber;
		this.reciepes = reciepes;
	}

	public Restaurant(Long id, String name, String address, String discription, String phonenumber,
			List<Recipe> reciepes) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.discription = discription;
		this.phonenumber = phonenumber;
		this.reciepes = reciepes;
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

	public List<Recipe> getReciepes() {
		return reciepes;
	}

	public void setReciepes(List<Recipe> reciepes) {
		this.reciepes = reciepes;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", discription=" + discription
				+ ", phonenumber=" + phonenumber + ", reciepes=" + reciepes + "]";
	}
	
}
