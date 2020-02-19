package com.plohoy.bulls.servlet;

import com.plohoy.bulls.exception.DaoException;
import com.plohoy.bulls.service.PlayerService;
import com.plohoy.bulls.view.PlayerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterPlayerServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterPlayerServlet.class);

    private static PlayerService service = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Hello!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            registerPlayer(req, resp);
        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private void registerPlayer(HttpServletRequest req, HttpServletResponse resp) throws DaoException {
        service.registerPlayer(req);
    }
}
