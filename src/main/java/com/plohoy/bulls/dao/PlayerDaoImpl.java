package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;
import com.plohoy.bulls.servlet.RegisterPlayerServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterPlayerServlet.class);

    private EntityManager em = Persistence.createEntityManagerFactory("persistence")
            .createEntityManager();

    @Override
    public void registerPlayer(HttpServletRequest req) throws DaoException {
        Player player = new Player();
        player.setFirstName(req.getParameter("firstName"));
        player.setLastName(req.getParameter("lastName"));
//        player.setLogin(req.getParameter("login"));
//        player.setPassword(req.getParameter("password"));
//        player.setScore(Integer.parseInt(req.getParameter("score")));
        try {
            em.getTransaction().begin();
            em.persist(player);

            em.getTransaction().commit();
        } catch (Exception ex) {

            LOGGER.error(ex.getMessage(), ex);
            em.getTransaction().rollback();
            throw new DaoException();
        }
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
