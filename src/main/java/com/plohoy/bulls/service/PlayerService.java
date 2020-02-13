package com.plohoy.bulls.service;

import com.plohoy.bulls.dao.PlayerDaoImpl;
import com.plohoy.bulls.domain.Player;

public class PlayerService {

    private PlayerDaoImpl dao;

    public void createPlayer() {
        dao.createPlayer();
    }

    public Player getPlayer() {
        return dao.getPlayer();
    }
}
