package com.groceryListBuilder.persistence;

import com.groceryListBuilder.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * The User dao.
 *
 * @author Sydney St. Clair
 */
public class UserDao {
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the by id
     */
    public User getById(int id) {
        Session session = getSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    /**
     * Save or update user.
     *
     * @param user the user
     */
    public void saveOrUpdate(User user) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    /**
     * Insert user.
     *
     * @param user the user
     * @return the int
     */
    public int insert(User user) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a user
     *
     * @param user User to be deleted
     */
    public void delete(User user) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    /**
     * Gets all users.
     *
     * @return all users
     */
    public List<User> getAll() {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();

        session.close();
        logger.debug("List of users: " + users);
        return users;
    }

    /**
     * Gets by property like.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property like
     */
    public List<User> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for users with {} = {}", propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    /**
     * Returns an open session from the session factory
     *
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }
}
