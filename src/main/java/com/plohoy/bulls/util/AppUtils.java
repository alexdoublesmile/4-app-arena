package com.plohoy.bulls.util;

import com.plohoy.bulls.domain.User;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AppUtils {

    private static int redirectId = 0;

    private static final Map<Integer, String> ID_URI_MAP = new HashMap<>();
    private static final Map<String, Integer> URI_ID_MAP = new HashMap<>();

    public static void storeLoginedUser(HttpSession session, User user) {
        session.setAttribute("loginedUser", user);
    }

    public static User getLoginedUser(HttpSession session) {
        User loginedUser = (User) session.getAttribute("loginedUser");
        return loginedUser;
    }

    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
        Integer id = URI_ID_MAP.get(requestUri);

        if (id == null) {
            id = redirectId++;

            URI_ID_MAP.put(requestUri, id);
            ID_URI_MAP.put(id, requestUri);
            return id;

        }
        return id;
    }

    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
        String url = ID_URI_MAP.get(redirectId);
        if (url != null) {
            return url;
        }

        return null;
    }
}
