package com.example.recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recipebook.model.Recipe;
import com.example.recipebook.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>  {

}
