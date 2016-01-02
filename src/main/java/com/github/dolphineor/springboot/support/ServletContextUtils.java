package com.github.dolphineor.springboot.support;

import com.google.common.collect.Lists;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created on 2016-01-02.
 *
 * @author dolphineor
 */
public class ServletContextUtils {

    private static List<String> staticResourcesSuffix = Lists.newArrayList(".ico", ".gif", ".jpg", ".jpeg", ".png", ".swf", ".css", ".js");

    public static HttpServletRequest getRequest() {
        RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
        return ((ServletRequestAttributes) ra).getRequest();
    }

    /**
     * <p>是否是加载静态资源的请求.
     *
     * @param request
     * @return
     */
    public static boolean checkStaticResourcesRequest(HttpServletRequest request) {
        String requestPath = request.getRequestURI();
        for (int i = 0, s = staticResourcesSuffix.size(); i < s; i++) {
            if (requestPath.contains(staticResourcesSuffix.get(i)))
                return true;
        }

        return false;
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static ServletContext getServletContext() {
        return ContextLoader.getCurrentWebApplicationContext().getServletContext();
    }
}
