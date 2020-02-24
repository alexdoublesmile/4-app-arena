package com.plohoy.bulls.service;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;
import org.junit.AfterClass;
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

    private static final String PLAYER_TEST_FIRSTNAME = "Дениска";
    private static final String PLAYER_TEST_LASTNAME = "Тестовый";
    private static final String PLAYER_TEST_LOGIN = "createdByIdeaTest";
    private static final String PLAYER_TEST_PASSWORD = "test";
    private static final int PLAYER_TEST_SCORE = 10;

    @BeforeClass
    public static void init() {
        emf = Persistence.createEntityManagerFactory("persistence");
        LOGGER.info("--------------------------------");
    }

    @AfterClass
    public static void close() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("RemoveAllTestData")
                .setParameter("login",PLAYER_TEST_LOGIN)
                .getResultList()
                .forEach(p -> {
                    em.remove(p);
                });
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Test
    public void checkRegisterService() {
        PlayerService service = new PlayerService();
        Player p = getTestPlayer();

        try {
            Long newPlayerId = service.registerPlayer(p);
            LOGGER.info("---> New testPlayer {} was added to DB by PlayerService(he'll be removed at the end of Test) - {}", newPlayerId, p.toString());
            Assert.assertTrue(newPlayerId != null);

        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    @Test
    public void checkFindService() {
        PlayerService service = new PlayerService();
        List<Player> playerList;
        try {
            playerList = service.findAllPlayers();

        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();
        }

        if (playerList.size() > 0) {
            playerList.forEach(p -> {
                System.out.println(p.getId() + " - " + p.getFirstName());
                LOGGER.info("{} - {} {}(login: {}, password: {})", p.getId(), p.getLastName(), p.getFirstName(), p.getLogin(), p.getPassword());

            });
        } else {
            System.out.println("There are no players in DB");
        }
        Assert.assertTrue(playerList != null);
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

    @Test
    public void checkDBConnection() {
        Player p = getTestPlayer();
        try {
            em = emf.createEntityManager();
            List<Player> playersList = em.createQuery("from Player ").getResultList();
            if (playersList.size() > 0) {
                Collections.reverse(playersList);
                LOGGER.info("---->>> Now Last in DB is {}", playersList.get(0).toString());

            } else {
                LOGGER.info("---->>> Now DB is empty.");
            }
            em.getTransaction().begin();

            em.persist(p);
            em.flush();
            LOGGER.info("player {} is added to DB...", p.getId());

            playersList = em.createQuery("from Player ").getResultList();
            Collections.reverse(playersList);
            LOGGER.info("now Last in DB is {}", playersList.get(0).toString());

//            em.merge(p);
            em.remove(p);
            LOGGER.info("player {} is removed from DB...", p.getId());

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
            LOGGER.info("And now again Last in DB is {}", playersList.get(0).toString());
            Assert.assertTrue(((Player) playersList.get(0)).getId() < p.getId());

        } else {
            LOGGER.info("And now DB is empty again.");
        }

    }
}