package com.plohoy.bulls.config;

import java.util.*;

public class SecurityConfig {

    public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "ADMIN";

    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        List<String> urlPatterns1 = new ArrayList<>();
        urlPatterns1.add("/userInfo");

        mapConfig.put(ROLE_USER, urlPatterns1);

        List<String> urlPatterns2 = new ArrayList<>();
        urlPatterns2.add("/userInfo");
        urlPatterns2.add("/admin");

        mapConfig.put(ROLE_ADMIN, urlPatterns2);


    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
