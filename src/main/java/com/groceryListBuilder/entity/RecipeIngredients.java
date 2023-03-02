package com.groceryListBuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Recipe ingredients.
 *
 * @author Sydney St Clair
 */
@Entity(name = "RecipeIngredients")
@Table(name = "recipe_ingredients")
public class RecipeIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "recipeId")
    private int recipeId;
    @Id
    @ManyToOne
    @JoinColumn(name = "ingredientId", referencedColumnName = "ingredientId")
    private Ingredients ingredient;
    private String measurmentUnit;
    private String quantity;

    /**
     * Instantiates a new Recipe ingredients.
     */
    public RecipeIngredients() {
    }

    /**
     * Instantiates a new Recipe ingredients.
     *
     * @param ingredient     the ingredient
     * @param measurmentUnit the measurment unit
     * @param quantity       the quantity
     */
    public RecipeIngredients(Ingredients ingredient, String measurmentUnit, String quantity) {
        this.ingredient = ingredient;
        this.measurmentUnit = measurmentUnit;
        this.quantity = quantity;
    }

    /**
     * Gets recipe id.
     *
     * @return the recipe id
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * Sets recipe id.
     *
     * @param recipeId the recipe id
     */
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * Gets ingredient.
     *
     * @return the ingredient
     */
    public Ingredients getIngredient() {
        return ingredient;
    }

    /**
     * Sets ingredient.
     *
     * @param ingredient the ingredient
     */
    public void setIngredient(Ingredients ingredient) {
        this.ingredient = ingredient;
    }

    /**
     * Gets measurment unit.
     *
     * @return the measurment unit
     */
    public String getMeasurmentUnit() {
        return measurmentUnit;
    }

    /**
     * Sets measurment unit.
     *
     * @param measurmentUnit the measurment unit
     */
    public void setMeasurmentUnit(String measurmentUnit) {
        this.measurmentUnit = measurmentUnit;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RecipeIngredients{" +
                "recipeId=" + recipeId +
                ", ingredient=" + ingredient +
                ", measurmentUnit='" + measurmentUnit + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
