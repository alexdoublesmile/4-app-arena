package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.User;
import com.plohoy.bulls.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public UserDaoImpl() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    @Override
    public Long create(User user) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);

            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception ex) {

            LOGGER.error(ex.getMessage(), ex);
            entityManager.getTransaction().rollback();
            throw new DaoException();
        }

        return user.getId();
    }

    @Override
    public User findById(Long id) throws DaoException {

        entityManager = factory.createEntityManager();
        User user = entityManager.createQuery("FROM User WHERE id =:id", User.class)
                .setParameter("id", id)
                .getSingleResult();

        entityManager.close();
        return user;
    }

    @Override
    public User findUser(String login, String password) throws DaoException {
        User user = null;

        entityManager = factory.createEntityManager();
        TypedQuery<User> userTypedQuery = entityManager.createQuery("FROM User WHERE login =:login AND password =:password", User.class)
                .setParameter("login", login)
                .setParameter("password", password);

        if (userTypedQuery.getResultList().size() > 0) {
            user = userTypedQuery.getSingleResult();
        }

        entityManager.close();

        return user;
    }

    @Override
    public List<User> findAllUsers() throws DaoException {

        entityManager = factory.createEntityManager();
        List<User> userList = entityManager.createQuery("FROM User")
                .getResultList();

        entityManager.close();
        return userList;
    }
}
