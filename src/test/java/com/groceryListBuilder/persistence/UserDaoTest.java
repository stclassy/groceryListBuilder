package com.groceryListBuilder.persistence;

import com.groceryListBuilder.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;
    @BeforeEach
    void setUp() {
        com.groceryListBuilder.test.util.Database database = com.groceryListBuilder.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(1);
        assertEquals("Joe", retrievedUser.getFirstName());
        assertEquals("Coyne", retrievedUser.getLastName());
        assertEquals("joeshmoe", retrievedUser.getUserName());

    }

    @Test
    void saveOrUpdateSuccess() {
    }

    @Test
    void insertSuccess() {
    }

    @Test
    void getAllSuccess() {
    }

    @Test
    void getByPropertyLikeSuccess() {
    }
}