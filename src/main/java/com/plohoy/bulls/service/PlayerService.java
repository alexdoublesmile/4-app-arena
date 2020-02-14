package com.plohoy.bulls.service;

import com.plohoy.bulls.dao.PlayerDaoImpl;
import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;
import com.plohoy.bulls.view.PlayerResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PlayerService {

    private PlayerDaoImpl dao = new PlayerDaoImpl();

    public void registerPlayer(HttpServletRequest req) throws DaoException {
        dao.registerPlayer(req);
    }

    public Player getPlayer() throws DaoException {
        return dao.getPlayer();
    }

    public List<Player> getAllPlayers() throws DaoException {
        return dao.getAllPlayers();
    }

}
