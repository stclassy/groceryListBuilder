package com.groceryListBuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Represents a Recipe Object.
 *
 * @author Sydney St. Clair
 */
@Entity(name = "Recipe")
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "recipeId")
    private int recipeId;
    private LocalDateTime createDate;
    @Column(name = "name")
    private String recipeName;
    private LocalDateTime updateDate = null;
    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName = "userId", nullable = false)
    private User user;

    /**
     * Instantiates a new Recipe.
     */
    public Recipe() {
    }

    /**
     * Instantiates a new Recipe.
     *
     * @param createDate the create date
     * @param recipeName the recipe name
     * @param user       the user
     */
    public Recipe(LocalDateTime createDate, String recipeName, User user) {
        this.createDate = createDate;
        this.recipeName = recipeName;
        this.user = user;
    }

    /**
     * Instantiates a new Recipe.
     *
     * @param createDate the create date
     * @param recipeName the recipe name
     * @param updateDate the update date
     * @param user       the user
     */
    public Recipe(LocalDateTime createDate, String recipeName, LocalDateTime updateDate, User user) {
        this.createDate = createDate;
        this.recipeName = recipeName;
        this.updateDate = updateDate;
        this.user = user;
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
     * Gets create date.
     *
     * @return the creation date
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * Sets create date.
     *
     * @param createDate the creation date
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets recipe name.
     *
     * @return the recipe name
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Sets recipe name.
     *
     * @param recipeName the recipe name
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * Gets update date.
     *
     * @return the update date
     */
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets update date.
     *
     * @param updateDate the update date
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", createDate=" + createDate +
                ", recipeName='" + recipeName + '\'' +
                ", updateDate=" + updateDate +
                ", user=" + user +
                '}';
    }
}
