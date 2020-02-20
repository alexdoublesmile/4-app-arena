package com.plohoy.bulls.service;

import com.plohoy.bulls.dao.PlayerDao;
import com.plohoy.bulls.dao.PlayerDaoImpl;
import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;
import com.plohoy.bulls.view.PlayerResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PlayerService {

    private PlayerDao dao = new PlayerDaoImpl();

    public Long registerPlayer(Player player) throws DaoException {
        return dao.registerPlayer(player);
    }

    public Player getPlayer() throws DaoException {
        return dao.getPlayer();
    }

    public List<Player> getAllPlayers() throws DaoException {
        return dao.getAllPlayers();
    }

}
