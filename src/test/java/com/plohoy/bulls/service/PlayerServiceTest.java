package com.plohoy.bulls.service;

import com.plohoy.bulls.domain.Player;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class PlayerServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceTest.class);

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private static final String PLAYER_TEST_FIRSTNAME = "Иван";
    private static final String PLAYER_TEST_LASTNAME = "Тестовый";
    private static final String PLAYER_TEST_LOGIN = "Vano21";
    private static final String PLAYER_TEST_PASSWORD = "qwerty";
    private static final int PLAYER_TEST_SCORE = 12;


    @BeforeClass
    public static void init() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }

    @Test
    public void checkDBConnection() {
        Player p = getTestPlayer();
        try {

            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(p);
            em.flush();
            LOGGER.info("---> player {} is creating...", p.getId());

            List playersList = em.createQuery("from Player ").getResultList();
            Collections.reverse(playersList);
            LOGGER.info("Now last player in the Table is {}", playersList.get(0).toString());

            em.remove(p);
            LOGGER.info("player {} is removing...", p.getId());

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {

            em.getTransaction().rollback();
            LOGGER.error(e.getMessage(), e);
        }

        em = emf.createEntityManager();
        List playersList = em.createQuery("from Player ").getResultList();
        Collections.reverse(playersList);
        LOGGER.info("And now last player in the table is {}", playersList.get(0).toString());
        em.close();

        Assert.assertTrue(((Player) playersList.get(0)).getId() < p.getId());
    }

    private Player getTestPlayer() {
        Player player = new Player();

        player.setFirstName(PLAYER_TEST_FIRSTNAME);
        player.setLastName(PLAYER_TEST_LASTNAME);
        player.setLogin(PLAYER_TEST_LOGIN);
        player.setPassword(PLAYER_TEST_PASSWORD);
        player.setScore(PLAYER_TEST_SCORE);

        return player;
    }
}