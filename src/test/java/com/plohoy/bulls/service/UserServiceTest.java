package com.plohoy.bulls.service;

import com.plohoy.bulls.domain.User;
import com.plohoy.bulls.exception.DaoException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class UserServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

//    private static EntityManagerFactory emf;
//    private static EntityManager em;

    private static SessionFactory factory;
    private static Session session;

    private static int USER_TEST_LOGIN_INDEX = 1;
    private static final String USER_TEST_FIRSTNAME = "Дениска";
    private static final String USER_TEST_LASTNAME = "Тестовый";
    private static final String USER_TEST_LOGIN = "createdByIdeaTest";
    private static final String USER_TEST_PASSWORD = "test";
    private static final String USER_TEST_FAKE_PASSWORD = "-1";
    private static final int USER_TEST_SCORE = 10;


    private static final Map<String,String> jdbcUrlSettings = new HashMap<>();

    static {
        String jdbcDbUrl = System.getenv("JDBC_DATABASE_URL");
        if (null != jdbcDbUrl) {
            jdbcUrlSettings.put("hibernate.connection.url", System.getenv("JDBC_DATABASE_URL"));
        }
        String jdbcDbUserName = System.getenv("JDBC_DATABASE_USERNAME");
        if (null != jdbcDbUserName) {
            jdbcUrlSettings.put("hibernate.connection.username", System.getenv("JDBC_DATABASE_USERNAME"));
        }
        String jdbcDbPassword = System.getenv("JDBC_DATABASE_PASSWORD");
        if (null != jdbcDbPassword) {
            jdbcUrlSettings.put("hibernate.connection.password", System.getenv("JDBC_DATABASE_PASSWORD"));
        }
    }

    @BeforeClass
    public static void init() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        }

        factory = buildSessionFactory();

//        Map<String,String> jdbcUrlSettings = new HashMap<>();
//        String jdbcDbUrl = System.getenv("JDBC_DATABASE_URL");
//        if (null != jdbcDbUrl) {
//            jdbcUrlSettings.put("javax.persistence.jdbc.url", System.getenv("JDBC_DATABASE_URL"));
//        }
//        String jdbcDbUserName = System.getenv("JDBC_DATABASE_USERNAME");
//        if (null != jdbcDbUserName) {
//            jdbcUrlSettings.put("javax.persistence.jdbc.user", System.getenv("JDBC_DATABASE_USERNAME"));
//        }
//        String jdbcDbPassword = System.getenv("JDBC_DATABASE_PASSWORD");
//        if (null != jdbcDbPassword) {
//            jdbcUrlSettings.put("javax.persistence.jdbc.password", System.getenv("JDBC_DATABASE_PASSWORD"));
//        }
//
//        emf = Persistence.createEntityManagerFactory("persistence", jdbcUrlSettings);
        LOGGER.info("--------------------------------");
    }

    @AfterClass
    public static void close() {
        session = factory.openSession();
        session.getTransaction().begin();
        session.createNamedQuery("SelectAllByLogin")
                .setParameter("login",USER_TEST_LOGIN + '%')
                .getResultList()
                .forEach(p -> {
                    session.remove(p);
                });

        LOGGER.info("All testData is removed from DB..");
        session.getTransaction().commit();
        session.close();
        factory.close();
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
        session = factory.openSession();
        List<User> userList = session.createQuery("from User")
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
            session = factory.openSession();
            List<User> userList = session.createQuery("from User").getResultList();
            if (userList.size() > 0) {
                Collections.reverse(userList);
                LOGGER.info("---->>> Now Last in DB is {}", userList.get(0).toString());

            } else {
                LOGGER.info("---->>> Now DB is empty.");
            }

            session.getTransaction().begin();
            session.persist(testUser);
            session.flush();
            LOGGER.info("User {} is added to DB...", testUser.getId());

            userList = session.createQuery("from User").getResultList();
            Collections.reverse(userList);
            LOGGER.info("now Last in DB is {}", userList.get(0).toString());

            session.remove(testUser);
            LOGGER.info("User {} is removed from DB...", testUser.getId());

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {

            session.getTransaction().rollback();
            LOGGER.error(e.getMessage(), e);
        }

        session = factory.openSession();
        List userList = session.createQuery("from User").getResultList();
        Collections.reverse(userList);
        session.close();

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

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .applySettings(jdbcUrlSettings)
                    .build();

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}