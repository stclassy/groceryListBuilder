package com.groceryListBuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Grocery ingredients.
 *
 * @author Sydney St Clair
 */
@Entity(name = "GroceryIngredients")
@Table(name = "grocery_ingredients")
public class GroceryIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "listId")
    private int listId;
    @Id
    @ManyToOne
    @JoinColumn(name = "ingredientId", referencedColumnName = "ingredientId")
    private Ingredients ingredient;
    private String quantity;
    private String measurmentUnit;

    /**
     * Instantiates a new Grocery ingredients.
     */
    public GroceryIngredients() {
    }

    /**
     * Instantiates a new Grocery ingredients.
     *
     * @param ingredient     the ingredient
     * @param quantity       the quantity
     * @param measurmentUnit the measurment unit
     */
    public GroceryIngredients(Ingredients ingredient, String quantity, String measurmentUnit) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.measurmentUnit = measurmentUnit;
    }

    /**
     * Gets list id.
     *
     * @return the list id
     */
    public int getListId() {
        return listId;
    }

    /**
     * Sets list id.
     *
     * @param listId the list id
     */
    public void setListId(int listId) {
        this.listId = listId;
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

    @Override
    public String toString() {
        return "GroceryIngredients{" +
                "listId=" + listId +
                ", ingredient=" + ingredient +
                ", quantity='" + quantity + '\'' +
                ", measurmentUnit='" + measurmentUnit + '\'' +
                '}';
    }
}
