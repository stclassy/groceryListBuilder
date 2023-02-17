package com.groceryListBuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime updateDate;
    @ManyToOne
    private User user;

    public Recipe() {
    }

    public Recipe(LocalDateTime createDate, String recipeName, LocalDateTime updateDate, User user) {
        this.createDate = createDate;
        this.recipeName = recipeName;
        this.updateDate = updateDate;
        this.user = user;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public User getUser() {
        return user;
    }

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
