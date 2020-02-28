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

@WebServlet(name = "LoginPlayerServlet", urlPatterns = "/login")
public class LoginPlayerServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterPlayerServlet.class);

    private PlayerService service = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Player player = null;

        try {
            player = service.findPlayer(login, password);
        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();
        }

        if(player != null) {
            req.getSession().setAttribute("player", player);
            resp.sendRedirect("static/index.html");

        } else {
            req.setAttribute("error", "Unknown user, please try again");
            getServletContext().getRequestDispatcher("/view/login.jsp").forward(req, resp);
        }
    }
}
