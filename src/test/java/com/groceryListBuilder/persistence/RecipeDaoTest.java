package com.groceryListBuilder.persistence;

import com.groceryListBuilder.entity.User;
import com.groceryListBuilder.entity.Recipe;
import com.groceryListBuilder.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeDaoTest {
    GenericDao dao;
    GenericDao userDao;

    User user;

    @BeforeEach
    void setUp() {
        dao = new GenericDao(Recipe.class);
        userDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getByIdSuccess() {
        Recipe retrievedRecipe = (Recipe)dao.getById(1);

        assertEquals("Chicken Parm", retrievedRecipe.getRecipeName());
        assertEquals(LocalDateTime.parse("2023-02-18T04:17:32"), retrievedRecipe.getCreateDate());

    }

    @Test
    void saveOrUpdateSuccess() {
        String newRecipeName = "Stuffed Chicken Parm";
        Recipe recipeToUpdate = (Recipe)dao.getById(1);
        recipeToUpdate.setRecipeName(newRecipeName);
        dao.saveOrUpdate(recipeToUpdate);
        Recipe updatedRecipe = (Recipe)dao.getById(1);
        assertEquals(newRecipeName, updatedRecipe.getRecipeName());
    }

    @Test
    void insertSuccess() {
        user =(User)userDao.getById(1);

        Recipe newRecipe = new Recipe(LocalDateTime.parse("2023-02-18T22:48:13"), "CrockPot CornedBeef", user);
        int id = dao.insert(newRecipe);

        assertNotEquals(0,id);

        Recipe insertedRecipe = (Recipe)dao.getById(id);

        assertNotNull(newRecipe.getUser());
        assertEquals(newRecipe.toString(),insertedRecipe.toString());

    }

    @Test
    void getAllSuccess() {
        List<Recipe> recipes = (List<Recipe>)dao.getAll();
        assertEquals(2, recipes.size());
    }

    @Test
    void deleteSuccess() {
        dao.delete((Recipe)dao.getById(2));
        assertNull((Recipe)dao.getById(2));
        user = (User)userDao.getById(2);
        assertNotNull(user);
    }

    @Test
    void getByPropertyEqualSuccess() {
        List<Recipe> recipes = (List<Recipe>)dao.findByPropertyEqual("recipeName", "Chicken Parm");
        assertEquals(1,recipes.size());
    }
}
