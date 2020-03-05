package com.plohoy.bulls.dao;

import com.plohoy.bulls.domain.User;
import com.plohoy.bulls.exception.DaoException;

import java.util.List;

public interface UserDao {


    Long create(User user) throws DaoException;

    User findById(Long id) throws DaoException;

    User findUser(String login, String password) throws DaoException;

    User findByLogin(String login) throws DaoException;

    List<User> findAllUsers() throws DaoException;
}
