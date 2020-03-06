package com.plohoy.bulls.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

public class UrlPatternUtils {

    private static boolean hasUrlPatternInContext(ServletContext ctx, String urlPattern) {
        Map<String, ? extends ServletRegistration> map = ctx.getServletRegistrations();

        for (String servletName : map.keySet()) {
            ServletRegistration sr = map.get(servletName);

            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    public static String getUrlPattern(HttpServletRequest req) {
        ServletContext servletContext = req.getServletContext();
        String servletPath = req.getServletPath();
        String pathInfo = req.getPathInfo();

        String urlPattern = null;
        if (pathInfo != null) {
            urlPattern = servletPath + "/*";
            return urlPattern;
        }
        urlPattern = servletPath;

        boolean hasUrlMapping = hasUrlPatternInContext(servletContext, urlPattern);

        if(hasUrlMapping) {
            return urlPattern;
        }

        int extensionIndex = servletPath.lastIndexOf('.');
        if(extensionIndex != -1) {
            String extension = servletPath.substring(extensionIndex + 1);
            urlPattern = "*." + extension;
            hasUrlMapping = hasUrlPatternInContext(servletContext, urlPattern);

            if(hasUrlMapping) {
                return urlPattern;
            }
        }
        return "/";
    }
}
