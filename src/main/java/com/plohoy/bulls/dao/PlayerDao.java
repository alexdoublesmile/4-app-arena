package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;

import java.util.List;

public interface PlayerDao {


    Long create(Player player) throws DaoException;

    Player findById(Long id) throws DaoException;

    Player findPlayer(String login, String password) throws DaoException;

    List<Player> findAll() throws DaoException;
}
