package com.recipes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recipes.entity.Recipes;
import com.recipes.service.RecipesService;

/**
 * 
 * @author Reya.Chowdhury class is responsible for processing incoming REST API
 *         requests, preparing a model, and returning the view to be rendered as
 *         a response
 *
 */
@RestController
public class RecipesController {
	@Autowired
	private RecipesService recipesService;

	/**
	 * This method is responsible for returning all the list of recipes when a GET
	 * request is send
	 * 
	 * @return the Recipes
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/recipes")
	public List<Recipes> getTopics() {
		return recipesService.getAllRecipes();
	}

	/**
	 * this method is responsible for fetching the list of recipes and returning the
	 * recipe which matches with the id that was provided in the request url
	 * 
	 * @param id
	 * @return the recipe
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/recipes/{id}")
	public Recipes getRecipesById(@PathVariable("id") int id) {
		return recipesService.getRecipesById(id);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/recipes/name={name}")
	public Recipes getRecipesByName(@PathVariable("name") String name) {
		return recipesService.getRecipesByName(name);
	}

	/**
	 * this method is responsible for fetching the list of recipes and returning the
	 * recipe which matches with the cooking instructions that was provided in the
	 * request url
	 * 
	 * @param cookingInstructions
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/recipes/cookingInstructions={cookingInstructions}")
	public List<Recipes> getRecipesByCookingInstructions(
			@PathVariable("cookingInstructions") String cookingInstructions) {
		return recipesService.getRecipesByCookingInstructions(cookingInstructions);
	}

	/**
	 * this method is responsible for fetching the list of recipes and returning the
	 * recipe which matches with the portion size that was provided in the request
	 * url
	 * 
	 * @param portionSize
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/recipes/portionSize={portionSize}")
	public List<Recipes> getRecipesByPortionSize(@PathVariable("portionSize") String portionSize) {
		return recipesService.getRecipesByPortionSize(portionSize);
	}

	/**
	 * this method is responsible for fetching the list of recipes and returning the
	 * recipe which matches with the dish type that was provided in the request url
	 * 
	 * @param dishType
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/recipes/dishType={dishType}")
	public List<Recipes> getRecipesByDishType(@PathVariable("dishType") String dishType) {
		return recipesService.getRecipesByDishType(dishType);
	}

	/**
	 * this method is responsible for fetching the list of recipes and returning the
	 * recipe which matches with the date that was provided in the request url
	 * 
	 * @param dishType
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/recipes/creationTime={creationTime}")
	public List<Recipes> getRecipesByDate(@PathVariable("creationTime") String creationTime) {
		return recipesService.getRecipesByDate(creationTime);
	}
	/**
	 * this method is responsible for fetching the list of recipes and returning the
	 * recipe which matches with the ingredients that was provided in the request
	 * url
	 * 
	 * @param ingredients
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/recipes/ingredients={ingredients}")
	public List<Recipes> getRecipesByIngredients(@PathVariable("ingredients") String ingredients) {
		return recipesService.getRecipesByIngredients(ingredients);
	}

	/**
	 * This method reads through the parameters passed as part of the POST request
	 * and passes on this details to be persisted in database
	 * 
	 * @param recipe
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, value = "/recipes")
	public void addNewRecipe(@RequestBody Recipes recipe) {
		recipesService.addRecipe(recipe);
	}

	/**
	 * This method first fetches the particular recipe via the id provided in url
	 * and next it updates the value of the parameters for the recipe object
	 * 
	 * @param recipe
	 * @param name
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT, value = "/recipes/{id}")
	public void updateRecipe(@RequestBody Recipes recipe, @PathVariable int id) {
				recipesService.updateRecipe(recipe, id);
	}

	/**
	 * This method deletes a particular entry when a DELETE request is send the id
	 * to be deleted is passed in the url
	 * 
	 * @param id
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.DELETE, value = "/recipes/{id}")
	public void deleteRecipe(@PathVariable int id) {
		recipesService.deleteRecipe(id);
	}
}