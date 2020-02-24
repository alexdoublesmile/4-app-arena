package com.plohoy.bulls.servlet;


import com.plohoy.bulls.domain.Player;
import com.plohoy.bulls.exception.DaoException;
import com.plohoy.bulls.service.PlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "recordsServlet", urlPatterns = {"/records"})
public class RecordsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PlayerService service = new PlayerService();
        PrintWriter writer = resp.getWriter();
        try {
            List<Player> playerList = service.findAllPlayers();
            if (playerList.size() > 0) {

                for(Player p : playerList) {
                    writer.write(String.format("<h3 align = \"center\">%s %s - %s очков</h3>", p.getFirstName(), p.getLastName(), p.getScore()));
                }
            } else {
                resp.getWriter().write("<h1 align=\"center\">DB is empty now.</h1>");

            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
