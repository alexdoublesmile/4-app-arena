package com.plohoy.bulls.util;

import com.plohoy.bulls.config.SecurityConfig;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

public class SecurityUtils {

    // Проверить требует ли данный 'request' входа в систему или нет.
    public static boolean isSecurityPage(HttpServletRequest req) {
        String urlPattern = UrlPatternUtils.getUrlPattern(req);

        Set<String> roles = SecurityConfig.getAllAppRoles();

        for(String role : roles) {
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null
                    && urlPatterns.contains(urlPattern)) {
                return true;
            }
        }

        return false;
    }

    // Проверить имеет ли данный 'request' подходящую роль?
    public static boolean hasPermission(HttpServletRequest req) {
        String urlPattern = UrlPatternUtils.getUrlPattern(req);

        Set<String> roles = SecurityConfig.getAllAppRoles();

        for (String role : roles) {
            if (!req.isUserInRole(role)) {
                continue;
            }

            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null
                    && urlPatterns.contains(urlPattern)) {
                return true;
            }
        }

        return false;
    }
}
