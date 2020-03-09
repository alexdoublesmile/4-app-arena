package com.plohoy.bulls.servlet;

import com.plohoy.bulls.domain.User;
import com.plohoy.bulls.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterServlet.class);
    public static final String LOGIN_IS_BUSY = "Логин уже занят. Выберите иной, пожалуйста";

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/WEB-INF/view/register.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try {
            User user = service.findByLogin(req.getParameter("login"));
            if (user == null) {
                Long id = service.create(getNewUser(req));
            } else {
                req.setAttribute("errorString", LOGIN_IS_BUSY);
                getServletContext().getRequestDispatcher("/WEB-INF/view/register.jsp")
                        .forward(req, resp);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            resp.getWriter().write("<h1 align=\"center\">Something wrong was happened - User was NOT added to DB.. Call to Alex and tell him about it</h1>");
            throw new RuntimeException();
        }

        resp.sendRedirect(getServletContext().getContextPath() + "/registerSuccess");
    }

    private User getNewUser(HttpServletRequest req) {
        User user = new User();

        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        user.setScore(Integer.parseInt(req.getParameter("score")));

        return user;
    }
}
