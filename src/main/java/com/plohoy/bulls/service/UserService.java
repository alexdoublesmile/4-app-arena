package com.plohoy.bulls.service;

import com.plohoy.bulls.dao.UserDao;
import com.plohoy.bulls.dao.UserDaoImpl;
import com.plohoy.bulls.domain.User;
import com.plohoy.bulls.exception.DaoException;

import java.util.List;

public class UserService {

    private UserDao dao = new UserDaoImpl();

    public Long create(User user) throws DaoException {
        return dao.create(user);
    }

    public User findById(Long id) throws DaoException {
        return dao.findById(id);
    }

    public User findUser(String login, String password) throws DaoException {
        return dao.findUser(login, password);
    }

    public List<User> findAllUsers() throws DaoException {
        return dao.findAllUsers();
    }

}
