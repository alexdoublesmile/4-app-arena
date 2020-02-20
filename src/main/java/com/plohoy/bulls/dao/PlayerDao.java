package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PlayerDao {


    Long registerPlayer(Player player) throws DaoException;

    Player getPlayer() throws DaoException;
    List<Player> getAllPlayers() throws DaoException;
}
