package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;

import java.util.List;

public interface PlayerDao {


    Long registerPlayer(Player player) throws DaoException;

    List<Player> findAllPlayers() throws DaoException;
}
