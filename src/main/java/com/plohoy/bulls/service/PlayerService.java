package com.plohoy.bulls.service;

import com.plohoy.bulls.dao.PlayerDaoImpl;
import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;

import java.util.List;

public class PlayerService {

    private PlayerDaoImpl dao = new PlayerDaoImpl();

    public void registerPlayer() throws DaoException {
        dao.registerPlayer();
    }

    public Player getPlayer() throws DaoException {
        return dao.getPlayer();
    }

    public List<Player> getAllPlayers() throws DaoException {
        return dao.getAllPlayers();
    }

}
