package com.plohoy.bulls.service;

import com.plohoy.bulls.domain.User;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UserServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private static int USER_TEST_LOGIN_INDEX = 1;
    private static final String USER_TEST_FIRSTNAME = "Дениска";
    private static final String USER_TEST_LASTNAME = "Тестовый";
    private static final String USER_TEST_LOGIN = "createdByIdeaTest";
    private static final String USER_TEST_PASSWORD = "test";
    private static final String USER_TEST_FAKE_PASSWORD = "-1";
    private static final int USER_TEST_SCORE = 10;

    @BeforeClass
    public static void init() {
        emf = Persistence.createEntityManagerFactory("persistence");
        LOGGER.info("--------------------------------");
    }

    @AfterClass
    public static void close() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("SelectAllByLogin")
                .setParameter("login",USER_TEST_LOGIN + '%')
                .getResultList()
                .forEach(p -> {
                    em.remove(p);
                });

        LOGGER.info("All testData is removed from DB..");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Test
    public void checkCreateService() {
        UserService service = new UserService();
        User testUser = getTestUser();

        try {
            Long newUserId = service.create(testUser);
            LOGGER.info(
                    "---> New testUser {} was added to DB by UserService(he'll be removed at the end of Test) - {}",
                    newUserId, testUser.toString());
            Assert.assertTrue(newUserId != null);

        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    @Test
    public void checkFindByIdService() {
        UserService service = new UserService();

        try {
            Long newId = service.create(getTestUser());
            User foundedUser = service.findById(newId);

            LOGGER.info("User {} was found by ID from DB - {}", newId, foundedUser.toString());
            Assert.assertTrue(foundedUser.getId() == newId);

        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();        }
    }

    @Test
    public  void checkFindNullUserService() {
        UserService service = new UserService();

        try {
            Long newId = service.create(getTestUser());
            User foundedUser = service.findUser(USER_TEST_LOGIN, USER_TEST_FAKE_PASSWORD);
            Assert.assertTrue(foundedUser == null);

        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();        }
    }

    @Test
    public  void checkFindByLoginService() {
        UserService service = new UserService();

        try {
            Long newId = service.create(getTestUser());
            User foundedUser = service.findUser(USER_TEST_LOGIN + USER_TEST_LOGIN_INDEX, USER_TEST_PASSWORD);
            User foundedByLoginUser = service.findByLogin(USER_TEST_LOGIN + USER_TEST_LOGIN_INDEX);
            Assert.assertTrue(foundedUser.equals(foundedByLoginUser));

        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();        }
    }


    @Test
    public void checkFindAllUsersService() {
        UserService service = new UserService();
        List<User> usersList = null;

        try {
            usersList = service.findAllUsers();

        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();
        }

        if (usersList.size() > 0) {
            usersList.forEach(p -> {
                LOGGER.info(
                        "{} - {} {}(login: {}, password: {})",
                        p.getId(), p.getLastName(), p.getFirstName(), p.getLogin(), p.getPassword());
            });
        } else {
            LOGGER.info("There are no Users in DB");
        }

        Assert.assertTrue(usersList != null);
    }

    @Test
    public void checkSortByScoreService() {
        UserService service = new UserService();
        List<User> randomFiveUsers = createFiveRandomUsers();

        LOGGER.info("Five Users were created with random score: {}, {}, {}, {}, {}",
                randomFiveUsers.get(0).getScore(),
                randomFiveUsers.get(1).getScore(),
                randomFiveUsers.get(2).getScore(),
                randomFiveUsers.get(3).getScore(),
                randomFiveUsers.get(4).getScore());

        service.sortByScore(randomFiveUsers);

        LOGGER.info("Five Users were sorted by Service: {}, {}, {}, {}, {}",
                randomFiveUsers.get(0).getScore(),
                randomFiveUsers.get(1).getScore(),
                randomFiveUsers.get(2).getScore(),
                randomFiveUsers.get(3).getScore(),
                randomFiveUsers.get(4).getScore());

        Assert.assertTrue(
                randomFiveUsers.get(0).getScore() > randomFiveUsers.get(1).getScore()
                && randomFiveUsers.get(1).getScore() > randomFiveUsers.get(2).getScore()
                && randomFiveUsers.get(2).getScore() > randomFiveUsers.get(3).getScore()
                && randomFiveUsers.get(3).getScore() > randomFiveUsers.get(4).getScore()
        );
    }

    @Test
    public void getRandomDictum() {
        UserService service = new UserService();
        String firstRandomDictum = service.getRandomDictum();
        String secondRandomDictum = service.getRandomDictum();

        LOGGER.info("1st random Dictum is: {}", firstRandomDictum);
        LOGGER.info("2nd random Dictum is: {}", secondRandomDictum);
        Assert.assertTrue(!firstRandomDictum.equals(secondRandomDictum));
    }

    private List<User> createFiveRandomUsers() {
        List<User> usersList = new ArrayList<>();
        User firstUser = getTestUser();
        User secondUser = getTestUser();
        User thirdUser = getTestUser();
        User fourthUser = getTestUser();
        User fifthUser = getTestUser();
        firstUser.setScore(getRandomInt(1000));
        secondUser.setScore(getRandomInt(1000));
        thirdUser.setScore(getRandomInt(1000));
        fourthUser.setScore(getRandomInt(1000));
        fifthUser.setScore(getRandomInt(1000));

        usersList.add(firstUser);
        usersList.add(secondUser);
        usersList.add(thirdUser);
        usersList.add(fourthUser);
        usersList.add(fifthUser);

        return usersList;
    }

    private int getRandomInt(int index) {
        int casted = (int) (Math.random() * index);
        return casted;
    }

    private User getTestUser() {
        User testUser = new User();

        testUser.setFirstName(USER_TEST_FIRSTNAME);
        testUser.setLastName(USER_TEST_LASTNAME);
        testUser.setLogin(getUserTestLogin());
        testUser.setPassword(USER_TEST_PASSWORD);
        testUser.setScore(USER_TEST_SCORE);

        return testUser;
    }

    private String getUserTestLogin() {
        em = emf.createEntityManager();
        List<User> userList = em.createQuery("from User")
                .getResultList();
        while (true) {
            int initialIndex = USER_TEST_LOGIN_INDEX;

            for (User user : userList) {
                if (user.getLogin().equals(USER_TEST_LOGIN + USER_TEST_LOGIN_INDEX)) {
                    USER_TEST_LOGIN_INDEX++;
                }
            }
            if (USER_TEST_LOGIN_INDEX == initialIndex) {
                break;
            }
        }
        return USER_TEST_LOGIN + USER_TEST_LOGIN_INDEX;
    }

    @Test
    public void checkDBConnection() {
        User testUser = getTestUser();
        try {
            em = emf.createEntityManager();
            List<User> userList = em.createQuery("from User").getResultList();
            if (userList.size() > 0) {
                Collections.reverse(userList);
                LOGGER.info("---->>> Now Last in DB is {}", userList.get(0).toString());

            } else {
                LOGGER.info("---->>> Now DB is empty.");
            }

            em.getTransaction().begin();
            em.persist(testUser);
            em.flush();
            LOGGER.info("User {} is added to DB...", testUser.getId());

            userList = em.createQuery("from User").getResultList();
            Collections.reverse(userList);
            LOGGER.info("now Last in DB is {}", userList.get(0).toString());

            em.remove(testUser);
            LOGGER.info("User {} is removed from DB...", testUser.getId());

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {

            em.getTransaction().rollback();
            LOGGER.error(e.getMessage(), e);
        }

        em = emf.createEntityManager();
        List userList = em.createQuery("from User").getResultList();
        Collections.reverse(userList);
        em.close();

        if (userList.size() > 0) {
            LOGGER.info("And now again Last in DB is {}", userList.get(0).toString());
            Assert.assertTrue(((User) userList.get(0)).getId() < testUser.getId());

        } else {
            LOGGER.info("And now DB is empty again.");
        }

    }

    @Test
    public void anyTest() {
    }
}