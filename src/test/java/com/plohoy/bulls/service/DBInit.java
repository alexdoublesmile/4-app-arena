package com.plohoy.bulls.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBInit {

    public static EntityManagerFactory startUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

        return emf;
    }

}
