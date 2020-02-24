package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;
import com.plohoy.bulls.servlet.RegisterPlayerServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterPlayerServlet.class);

    private EntityManager entityManager;

    public PlayerDaoImpl() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    @Override
    public Long registerPlayer(Player player) throws DaoException {
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
    public Player getPlayer() throws DaoException {
        return null;
    }

    @Override
    public List<Player> findAllPlayers() throws DaoException {
        return entityManager.createQuery("SELECT p FROM Player p").getResultList();
    }
}
