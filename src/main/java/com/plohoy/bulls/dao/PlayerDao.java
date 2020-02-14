package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PlayerDao {

    void registerPlayer(HttpServletRequest req) throws DaoException;
    Player getPlayer() throws DaoException;
    List<Player> getAllPlayers() throws DaoException;
}
