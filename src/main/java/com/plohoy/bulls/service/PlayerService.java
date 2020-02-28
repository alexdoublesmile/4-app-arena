package com.plohoy.bulls.service;

import com.plohoy.bulls.dao.PlayerDao;
import com.plohoy.bulls.dao.PlayerDaoImpl;
import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;

import java.util.List;

public class PlayerService {

    private PlayerDao dao = new PlayerDaoImpl();

    public Long create(Player player) throws DaoException {
        return dao.create(player);
    }

    public Player findById(Long id) throws DaoException {
        return dao.findById(id);
    }

    public Player findPlayer(String login, String password) throws DaoException {
        return dao.findPlayer(login, password);
    }

    public List<Player> findAll() throws DaoException {
        return dao.findAll();
    }

}
