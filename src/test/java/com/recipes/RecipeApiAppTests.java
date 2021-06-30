package com.recipes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.recipes.entity.Recipes;
import com.recipes.repository.RecipeRepository;
import com.recipes.service.RecipesService;

/**
 * 
 * @author Reya.Chowdhury Test class to cover the CRUD functionalities
 *
 */
@SpringBootTest
class RecipeApiAppTests {

	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	RecipesService recipeService;

	Recipes recipe;
	
	@BeforeEach
	public void setup() {
		recipe = new Recipes();
		recipe.setId(50);
		recipe.setName("squids");
		recipe.setCreationTime("30-06-2021 12:22");
		recipe.setDishType("nonvegetarian");
		recipe.setPortionSize("6");
		recipe.setCookingInstructions("mix all together and fry in hot oil");
		recipe.setIngredients("squid,egg,oil");
	}
	@Test
	public void testCreate() {
		setup();
		recipeRepository.save(recipe);
		assertThat(!recipeRepository.findById(46).get().equals(null));

	}

	@Test
	public void testAll() {
		List<Recipes> recipeList = recipeRepository.findAll();
		assertThat(recipeList.size() >= 0);
	}

	@Test
	public void testSingleRecordById() {
		Recipes recipe = recipeRepository.findById(43).get();
		assertThat(recipe.getId()==43);

	}
	
	@Test
	public void testSingleRecordByName() {
		assertThat(recipe.getName().equals("tea"));

	}
	
	@Test
	public void testSingleRecordByPortionSize() {
		Recipes recipe = recipeRepository.findById(43).get();
		assertThat(recipe.getPortionSize().equals("2"));

	}
	
	@Test
	public void testSingleRecordByIngredients() {
		Recipes recipe = recipeRepository.findById(43).get();
		assertThat(recipe.getIngredients().contains("tea"));

	}
	
	@Test
	public void testSingleRecordByCreationDate() {
		Recipes recipe = recipeRepository.findById(43).get();
		assertThat(recipe.getCreationTime().contains("30-06-2021"));

	}
	
	@Test
	public void testSingleRecordByDishType() {
		Recipes recipe = recipeRepository.findById(43).get();
		assertThat(recipe.getDishType().equals("nonvegetarian"));

	}
	
	@Test
	public void testSingleRecordByCookingInstructions() {
		Recipes recipe = recipeRepository.findById(43).get();
		assertThat(recipe.getCookingInstructions().contains("mix"));

	}
	
	@Test
	public void testUpdate() {
		Recipes recipe = recipeRepository.findById(46).get();
		recipe.setPortionSize("4");
		assertThat(!recipe.getPortionSize().equalsIgnoreCase("6"));
	}

	@Test
	public void testDelete() {
		recipeRepository.deleteById(47);
		assertThat(recipeRepository.existsById(47)).isFalse();
	}

}
