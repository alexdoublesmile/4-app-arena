package com.plohoy.bulls.service;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;
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
    private static final String PLAYER_TEST_LOGIN = "IDEAcreated";
    private static final String PLAYER_TEST_PASSWORD = "test";
    private static final int PLAYER_TEST_SCORE = 0;


    @BeforeClass
    public static void init() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }

    @Test
    public void checkDBConnection() {
        Player p = getTestPlayer();
        try {
            em = emf.createEntityManager();
            List<Player> playersList = em.createQuery("from Player ").getResultList();
            if (playersList.size() > 0) {
                Collections.reverse(playersList);
                LOGGER.info("---> Now last player in the Table is {}", playersList.get(0).toString());

            } else {
                LOGGER.info("---> Now Players Table is empty.");
            }
            em.getTransaction().begin();

            em.persist(p);
            em.flush();
            LOGGER.info("player {} is adding to DB...", p.getId());

            playersList = em.createQuery("from Player ").getResultList();
            Collections.reverse(playersList);
            LOGGER.info("Now last player in the Table is {}", playersList.get(0).toString());

            em.merge(p);
            em.remove(p);
            LOGGER.info("player {} is removing from DB...", p.getId());

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {

            em.getTransaction().rollback();
            LOGGER.error(e.getMessage(), e);
        }

        em = emf.createEntityManager();
        List playersList = em.createQuery("from Player ").getResultList();
        Collections.reverse(playersList);
        em.close();

        if (playersList.size() > 0) {
            LOGGER.info("And now last player in the Table is {}", playersList.get(0).toString());
            Assert.assertTrue(((Player) playersList.get(0)).getId() < p.getId());

        } else {
            LOGGER.info("And now Players Table is empty again.");
        }

    }

    @Test
    public void registerPlayer() {
        Player p = getTestPlayer();
        PlayerService service = new PlayerService();
        try {
            LOGGER.info("---->>> New player for Hibernate is {}", service.registerPlayer(p));


        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();
        }
        em = emf.createEntityManager();
        List playersList = em.createQuery("from Player ").getResultList();
        Collections.reverse(playersList);
        em.close();
        Assert.assertTrue(((Player) playersList.get(0)).getId() == p.getId());

    }

    @Test
    public void getAllPlayers() {
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