package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;
import com.plohoy.bulls.servlet.RegisterPlayerServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterPlayerServlet.class);

    private EntityManager em;

    private EntityManager getEm() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();

        return em;
    }

    @Override
    public Long registerPlayer(Player player) throws DaoException {
        try {
            em = getEm();
            em.getTransaction().begin();
            em.persist(player);

            em.getTransaction().commit();
            em.close();
        } catch (Exception ex) {

            LOGGER.error(ex.getMessage(), ex);
            em.getTransaction().rollback();
            throw new DaoException();
        }

        return player.getId();
    }

    @Override
    public Player getPlayer() throws DaoException {
        return null;
    }

    @Override
    public List<Player> getAllPlayers() throws DaoException {
        return null;
    }
}
