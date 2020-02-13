package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.Player;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PlayerDaoImpl implements PlayerDao {

    private EntityManager em;

    @Override
    public void createPlayer() {

    }

    @Override
    public Player getPlayer() {
        return null;
    }
}
