package com.plohoy.bulls.config;

import java.util.*;

public class SecurityConfig {

    public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_MODER = "MODER";

    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        List<String> urlPatternsForUser = new ArrayList<>();
        urlPatternsForUser.add("/userInfo");
        urlPatternsForUser.add("/games");

        mapConfig.put(ROLE_USER, urlPatternsForUser);

        List<String> urlPatternsForModer = new ArrayList<>();
        urlPatternsForModer.add("/userInfo");
        urlPatternsForModer.add("/games");
        urlPatternsForModer.add("/moder");

        mapConfig.put(ROLE_MODER, urlPatternsForModer);

        List<String> urlPatternsForAdmin = new ArrayList<>();
        urlPatternsForAdmin.add("/userInfo");
        urlPatternsForAdmin.add("/games");
        urlPatternsForAdmin.add("/admin");
        urlPatternsForAdmin.add("/moder");

        mapConfig.put(ROLE_ADMIN, urlPatternsForAdmin);


    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
