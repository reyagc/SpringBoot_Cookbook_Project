package com.recipes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Reya.Chowdhury The Recipe entity represents a table in a mysql
 *         database, and each entity instance corresponds to a row in that
 *         table.
 *
 */
@Entity
@Table(name = "recipes")
public class Recipes {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String creationTime;
	private String dishType;
	private String portionSize;
	private String ingredients;
	private String cookingInstructions;

	public Recipes() {

	}

	public Recipes(String name, String creationTime, String dishType, String portionSize, String ingredients,
			String cookingInstructions) {
		super();
		this.name = name;
		this.creationTime = creationTime;
		this.dishType = dishType;
		this.portionSize = portionSize;
		this.ingredients = ingredients;
		this.cookingInstructions = cookingInstructions;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the creationTime
	 */
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @return the dishType
	 */
	public String getDishType() {
		return dishType;
	}

	/**
	 * @param dishType the dishType to set
	 */
	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	/**
	 * @return the portionSize
	 */
	public String getPortionSize() {
		return portionSize;
	}

	/**
	 * @param portionSize the portionSize to set
	 */
	public void setPortionSize(String portionSize) {
		this.portionSize = portionSize;
	}

	/**
	 * @return the ingredients
	 */
	public String getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the cookingInstructions
	 */
	public String getCookingInstructions() {
		return cookingInstructions;
	}

	/**
	 * @param cookingInstructions the cookingInstructions to set
	 */
	public void setCookingInstructions(String cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}

	/*
	 * list of all the attributes in string format
	 */
	@Override
	public String toString() {
		return "Recipes [name=" + name + ", creationTime=" + creationTime + ", dishType=" + dishType + ", portionSize="
				+ portionSize + ", ingredients=" + ingredients + ", cookingInstructions=" + cookingInstructions + "]";
	}

}
