package com.plohoy.bulls.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;
import java.util.List;

public class UserRoleRequestWrapper extends HttpServletRequestWrapper {

    private String userLogin;
    private List<String> userRoles;
    private HttpServletRequest realRequest;

    public UserRoleRequestWrapper(String userLogin, List<String> userRoles, HttpServletRequest request) {
        super(request);
        this.userLogin = userLogin;
        this.userRoles = userRoles;
        this.realRequest = request;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (userRoles == null) {
            return realRequest.isUserInRole(role);
        }

        return userRoles.contains(role);
    }

    @Override
    public Principal getUserPrincipal() {
        if (userLogin == null) {
            return realRequest.getUserPrincipal();
        }

        return () -> userLogin;
    }
}
