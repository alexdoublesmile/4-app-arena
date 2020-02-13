package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {

    private EntityManager em = Persistence.createEntityManagerFactory("persistence")
            .createEntityManager();

    @Override
    public void registerPlayer() throws DaoException {

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
