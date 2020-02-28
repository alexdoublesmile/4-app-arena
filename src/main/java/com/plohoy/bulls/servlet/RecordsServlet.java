package com.plohoy.bulls.servlet;


import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;
import com.plohoy.bulls.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "recordsServlet", urlPatterns = {"/records"})
public class RecordsServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecordsServlet.class);

    private PlayerService service = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Player> playerList;

        try {
            playerList = service.findAll();

        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();
        }

        req.setAttribute("playerList", playerList);
        getServletContext().getRequestDispatcher("/view/records.jsp").forward(req, resp);

    }
}
