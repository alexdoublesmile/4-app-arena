package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;
import com.plohoy.bulls.servlet.RegisterPlayerServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterPlayerServlet.class);

    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public PlayerDaoImpl() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    @Override
    public Long create(Player player) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(player);

            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception ex) {

            LOGGER.error(ex.getMessage(), ex);
            entityManager.getTransaction().rollback();
            throw new DaoException();
        }

        return player.getId();
    }

    @Override
    public Player findById(Long id) throws DaoException {

        entityManager = factory.createEntityManager();
        Player player = entityManager.createQuery("FROM Player WHERE id =:id", Player.class)
                .setParameter("id", id)
                .getSingleResult();

        entityManager.close();
        return player;
    }

    @Override
    public Player findPlayer(String login, String password) throws DaoException {

        entityManager = factory.createEntityManager();
        Player player = entityManager.createQuery("FROM Player WHERE login =:login AND password =:password", Player.class)
                .setParameter("login", login)
                .setParameter("password", password)
                .getSingleResult();

        entityManager.close();
        return player;
    }

    @Override
    public List<Player> findAll() throws DaoException {

        entityManager = factory.createEntityManager();
        List<Player> playerList = entityManager.createQuery("FROM Player")
                .getResultList();

        entityManager.close();
        return playerList;
    }
}
