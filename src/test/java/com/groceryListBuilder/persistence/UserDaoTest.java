package com.groceryListBuilder.persistence;

import com.groceryListBuilder.entity.User;
import com.groceryListBuilder.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    GenericDao dao;
    @BeforeEach
    void setUp() {
        dao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)dao.getById(1);

        assertEquals("Joe", retrievedUser.getFirstName());
        assertEquals("Coyne", retrievedUser.getLastName());
        assertEquals("joeshmoe", retrievedUser.getUserName());
        assertEquals(LocalDateTime.parse("2023-02-10T12:36:47"), retrievedUser.getCreateDate());

    }

    @Test
    void saveOrUpdateSuccess() {
        String newUserName = "Joey";
        User userToUpdate = (User)dao.getById(1);
        userToUpdate.setUserName(newUserName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)dao.getById(1);
        assertEquals(newUserName, retrievedUser.getUserName());
    }

    @Test
    void insertSuccess() {
        User newUser = new User(3, "Henry", "Fright", "Knightly", "super safe password", LocalDateTime.parse("2023-02-12T02:40:33"));
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)dao.getById(id);
        assertEquals(newUser.toString(), insertedUser.toString());
    }

    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.findByPropertyEqual ("lastName", "Coyne");
        assertEquals(1, users.size());
    }
}