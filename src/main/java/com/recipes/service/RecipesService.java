package com.recipes.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipes.entity.Recipes;
import com.recipes.repository.RecipeRepository;

/**
 * 
 * @author Reya.Chowdhury This class covers the business logic of the controller
 *         class for the various operations on the Recipes
 *
 */
@Service
public class RecipesService {

	@Autowired
	private RecipeRepository recipeRepository;

	/**
	 * This method holds the logic for fetching all the recipe objects from the sql
	 * database adds it to a list
	 * 
	 * @return the entire set of recipes
	 */
	public List<Recipes> getAllRecipes() {
		List<Recipes> recipes = new ArrayList<>();
		recipeRepository.findAll().forEach(recipes::add);
		System.out.println("repo::::::" + recipeRepository.findAll());
		return recipes;
	}

	/**
	 * This method parses through each of the recipe object and returns one based on
	 * the criteria of id provided
	 * 
	 * @param id is passed as input from the url
	 * @return the Recipe object
	 */
	public Recipes getRecipesById(int id) {
		List<Recipes> recipes = new ArrayList<>();
		recipeRepository.findAll().forEach(recipes::add);
		return recipes.stream().filter(t -> t.getId() == id).findFirst().get();

	}

	/**
	 * This method parses through each of the recipe object and returns one based on
	 * the name provided
	 * 
	 * @param name of the recipe
	 * @return the Recipe object
	 */
	public Recipes getRecipesByName(String name) {
		List<Recipes> recipes = new ArrayList<>();
		recipeRepository.findAll().forEach(recipes::add);
		return recipes.stream().filter(t -> t.getName().equals(name)).findFirst().get();
	}

	/**
	 * This method persists the Recipe entity parameters that are passed from the
	 * web url. The data is stored on the my sql database
	 * 
	 * @param recipe object
	 */
	public void addRecipe(Recipes recipe) {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String strDate = sdf.format(cal.getTime());
		recipe.setCreationTime(strDate);
		recipeRepository.save(recipe);
	}

	/**
	 * This method updates the changes in the recipe entity and stores it in the
	 * database
	 * 
	 * @param recipe object parameters
	 * @param name   of the recipe
	 */
	public void updateRecipe(Recipes recipe, int id) {
		  Calendar cal = Calendar.getInstance(); 
		  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm"); 
		  String strDate = sdf.format(cal.getTime()); 
		  recipe.setCreationTime(strDate);
		recipeRepository.save(recipe);
	}

	/**
	 * This method deletes the recipe and displays the updated list in the front end
	 * 
	 * @param id to be deleted
	 */
	public void deleteRecipe(int id) {
		recipeRepository.deleteById(id);
	}

	/**
	 * This method Filters the recipe based on the diet preference provided through
	 * the url
	 * 
	 * @param dishType
	 * @return List of recipes
	 */
	public List<Recipes> getRecipesByDishType(String dishType) {
		List<Recipes> recipes = new ArrayList<>();
		List<Recipes> selectedRecipes = new ArrayList<>();
		recipeRepository.findAll().forEach(recipes::add);
		for (Recipes recipe : recipes) {
			if (recipe.getDishType().equalsIgnoreCase(dishType)) {
				selectedRecipes.add(recipe);
			}
		}
		return selectedRecipes;

	}

	/**
	 * This method Filters the recipe based on the ingredients provided through the
	 * url
	 * 
	 * @param ingredients
	 * @return List of recipes
	 */
	public List<Recipes> getRecipesByIngredients(String ingredients) {
		List<Recipes> recipes = new ArrayList<>();
		List<Recipes> selectedRecipes = new ArrayList<>();
		recipeRepository.findAll().forEach(recipes::add);
		for (Recipes recipe : recipes) {
			if (recipe.getIngredients().contains(ingredients)) {
				selectedRecipes.add(recipe);
			}
		}
		return selectedRecipes;
	}

	/**
	 * This method Filters the recipe based on the cooking instructions provided
	 * through the url
	 * 
	 * @param cookingInstructions
	 * @return List of recipes
	 */
	public List<Recipes> getRecipesByCookingInstructions(String cookingInstructions) {
		List<Recipes> recipes = new ArrayList<>();
		List<Recipes> selectedRecipes = new ArrayList<>();
		recipeRepository.findAll().forEach(recipes::add);
		for (Recipes recipe : recipes) {
			if (recipe.getCookingInstructions().contains(cookingInstructions)) {
				selectedRecipes.add(recipe);
			}
		}
		return selectedRecipes;
	}
	/**
	 * This method Filters the recipe based on the cooking instructions provided
	 * through the url
	 * 
	 * @param cookingInstructions
	 * @return List of recipes
	 */
	public List<Recipes> getRecipesByDate(String creationTime) {
		List<Recipes> recipes = new ArrayList<>();
		List<Recipes> selectedRecipes = new ArrayList<>();
		recipeRepository.findAll().forEach(recipes::add);
		for (Recipes recipe : recipes) {
			if (recipe.getCreationTime().contains(creationTime)) {
				selectedRecipes.add(recipe);
			}
		}
		return selectedRecipes;
	}
	/**
	 * This method Filters the recipe based on the portion size through the url
	 * 
	 * @param portionSize
	 * @return List of recipes
	 */
	public List<Recipes> getRecipesByPortionSize(String portionSize) {
		List<Recipes> recipes = new ArrayList<>();
		List<Recipes> selectedRecipes = new ArrayList<>();
		recipeRepository.findAll().forEach(recipes::add);
		for (Recipes recipe : recipes) {
			if (recipe.getPortionSize().equalsIgnoreCase(portionSize)) {
				selectedRecipes.add(recipe);
			}
		}
		return selectedRecipes;
	}
}
