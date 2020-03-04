package com.plohoy.bulls.filter;

import com.plohoy.bulls.domain.Role;
import com.plohoy.bulls.domain.User;
import com.plohoy.bulls.request.UserRoleRequestWrapper;
import com.plohoy.bulls.util.AppUtils;
import com.plohoy.bulls.util.SecurityUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = {"/*"})
public class SecurityFilter implements Filter {

    public SecurityFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String servletPath = req.getServletPath();

        User loginedUser = AppUtils.getLoginedUser(req.getSession());

        if (servletPath.equals("/login")) {
            filterChain.doFilter(req, resp);
            return;
        }

        HttpServletRequest wrapRequest = req;

        if (loginedUser != null) {
            String userLogin = loginedUser.getLogin();

            List<Role> roles = (List<Role>) loginedUser.getRoles();

            wrapRequest = new UserRoleRequestWrapper(userLogin, roles, req);
        }

        if (SecurityUtils.isSecurityPage(req)) {

            if (loginedUser == null) {
                String requestUri = req.getRequestURI();

                int redirectId = AppUtils.storeRedirectAfterLoginUrl(req.getSession(), requestUri);
                resp.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
                return;
            }

            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {
                req.getServletContext().getRequestDispatcher("/WEB-INF/view/accessDeniedView.jsp")
                        .forward(req, resp);
                return;
            }
        }

        filterChain.doFilter(wrapRequest, resp);

    }

    @Override
    public void destroy() {

    }
}
