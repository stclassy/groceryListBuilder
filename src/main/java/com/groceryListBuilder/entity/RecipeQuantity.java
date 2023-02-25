package com.groceryListBuilder.entity;

import javax.persistence.*;

/**
 * The type Recipe quantity.
 */
@Entity(name = "RecipeQuantity")
@Table(name = "measurment_quantity")
public class RecipeQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "measurmentQtyId")
    private int measurementId;
    private String amount;

    /**
     * Instantiates a new Recipe quantity.
     */
    public RecipeQuantity() {
    }

    /**
     * Instantiates a new Recipe quantity.
     *
     * @param amount the amount
     */
    public RecipeQuantity(String amount) {
        this.amount = amount;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RecipeQuantity{" +
                "measurementId=" + measurementId +
                ", amount='" + amount + '\'' +
                '}';
    }
}
