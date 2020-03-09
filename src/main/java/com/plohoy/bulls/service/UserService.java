package com.plohoy.bulls.service;

import com.plohoy.bulls.dao.UserDao;
import com.plohoy.bulls.dao.UserDaoImpl;
import com.plohoy.bulls.domain.Dictums;
import com.plohoy.bulls.domain.User;
import com.plohoy.bulls.exception.DaoException;
import org.hibernate.mapping.Collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserService {

    private UserDao dao = new UserDaoImpl();

    public Long create(User user) throws DaoException {
        return dao.create(user);
    }

    public User findById(Long id) throws DaoException {
        return dao.findById(id);
    }

    public User findByLogin(String login) throws DaoException {
        return dao.findByLogin(login);
    }

    public User findUser(String login, String password) throws DaoException {
        return dao.findUser(login, password);
    }

    public List<User> findAllUsers() throws DaoException {
        return dao.findAllUsers();
    }

    public List<User> sortByScore(List<User> usersList) {
        Comparator<User> scoreComparator = Comparator.comparing(user -> user.getScore());
        Collections.sort(usersList, scoreComparator);
        Collections.reverse(usersList);

        return usersList;
    }

    public String getRandomDictum() {
        int randomIndex = (int) (Math.random() * Dictums.getDictums().size());

        return Dictums.getDictums().get(randomIndex);
    }
}
