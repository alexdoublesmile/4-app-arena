package com.plohoy.bulls.servlet;

import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", urlPatterns = {"/register"})
public class RegisterPlayerServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterPlayerServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        PlayerService service = new PlayerService();
        Player player = new Player();
        Long id;

        try {
            player.setFirstName(req.getParameter("firstName"));
            player.setLastName(req.getParameter("lastName"));
            player.setLogin(req.getParameter("login"));
            player.setPassword(req.getParameter("password"));
            player.setScore(Integer.parseInt(req.getParameter("score")));
            id = service.registerPlayer(player);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            resp.getWriter().write("<h1 align=\"center\">------->>>>>> Player was NOT added to DB..</h1>");

            throw new RuntimeException();

        }

        req.setAttribute("message", "<script>alert('Регистрация в базе прошла успешно!')</script>");
        getServletContext().getRequestDispatcher("/view/profile.jsp").forward(req, resp);

    }
}
