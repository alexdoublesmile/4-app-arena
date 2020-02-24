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
import java.io.PrintWriter;

@WebServlet(name = "registerServlet", urlPatterns = {"/register"})
public class RegisterPlayerServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterPlayerServlet.class);

//    private PlayerService service;
//    private Player player;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//
//        service = new PlayerService();
//        player = new Player();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html");
//
//        String name = req.getParameter("name");
//        if(name != null && !name.trim().isEmpty()) {
//            resp.getWriter().write(String.format("<h1>Сервлеты, которые создал %s! :)</h1>", name));
//
//        } else {
//            resp.getWriter().write("<h1>Сервлеты ё! :)</h1>");
//
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");



//        LOGGER.info("!!!Player was created -->> {}", player.toString());
        try {
            PlayerService service = new PlayerService();
            Player player = new Player();


            player.setFirstName(req.getParameter("firstName"));
            player.setLastName(req.getParameter("lastName"));
            player.setLogin(req.getParameter("login"));
            player.setPassword(req.getParameter("password"));
            player.setScore(Integer.parseInt(req.getParameter("score")));
            Long id = service.registerPlayer(player);
            resp.getWriter().write(String.format("<h1>Player %s was successfully added to DB..</h1>", id));
            resp.getWriter().write(String.format("<p align=\"center\">his name is %s %s</p>", player.getLastName(), player.getFirstName()));


        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            resp.getWriter().write("<h1 align=\"center\">------->>>>>> Player was NOT added to DB..</h1>");

            throw new RuntimeException();

        }


    }
}
