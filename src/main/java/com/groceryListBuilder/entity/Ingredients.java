package com.groceryListBuilder.entity;

import javax.persistence.*;

/**
 * The type Ingredient.
 *
 * @author Sydney St Clair
 */
@Entity(name = "Ingredients")
@Table(name = "ingredients")
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ingredientId")
    private int ingredientId;
    private String ingredientName;

    /**
     * Instantiates a new Ingredients.
     */
    public Ingredients() {
    }

    /**
     * Instantiates a new Ingredients.
     *
     * @param ingredientName the ingredient name
     */
    public Ingredients(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    /**
     * Gets ingredient id.
     *
     * @return the ingredient id
     */
    public int getIngredientId() {
        return ingredientId;
    }

    /**
     * Sets ingredient id.
     *
     * @param ingredientId the ingredient id
     */
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    /**
     * Gets ingredient name.
     *
     * @return the ingredient name
     */
    public String getIngredientName() {
        return ingredientName;
    }

    /**
     * Sets ingredient name.
     *
     * @param ingredientName the ingredient name
     */
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredientId=" + ingredientId +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}
