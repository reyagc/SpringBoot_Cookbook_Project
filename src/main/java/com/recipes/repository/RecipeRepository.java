package com.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipes.entity.Recipes;

/**
 * @author Reya.Chowdhury
 * Repository class is used to indicate that the class provides the mechanism for storage,
 *  retrieval, search, update and delete operation on Recipe object
 */
public interface RecipeRepository extends JpaRepository<Recipes,Integer>{

}
 