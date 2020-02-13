package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;

import java.util.List;

public interface PlayerDao {

    void registerPlayer() throws DaoException;
    Player getPlayer() throws DaoException;
    List<Player> getAllPlayers() throws DaoException;
}
