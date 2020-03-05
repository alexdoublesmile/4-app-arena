package com.plohoy.bulls.servlet;


import com.plohoy.bulls.domain.User;
import com.plohoy.bulls.exception.DaoException;
import com.plohoy.bulls.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersListServlet", urlPatterns = {"/usersList"})
public class UsersListServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersListServlet.class);

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<User> usersList;

        try {
            usersList = service.findAllUsers();

        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();
        }

        req.setAttribute("usersList", usersList);
        getServletContext().getRequestDispatcher("/WEB-INF/view/usersList.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
