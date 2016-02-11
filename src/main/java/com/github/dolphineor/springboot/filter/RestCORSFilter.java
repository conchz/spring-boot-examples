package com.github.dolphineor.springboot.filter;

import com.github.dolphineor.springboot.support.ServletContextUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2015-09-12.
 * {@code RestCORSFilter} responds to all requests with certain Access-Control-* headers.
 *
 * @author dolphineor
 */
@Configuration
public class RestCORSFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Filter static resources
        boolean isStaticResourcesRequest = ServletContextUtils.checkStaticResourcesRequest(request);
        if (isStaticResourcesRequest) {
            filterChain.doFilter(request, response);
            return;
        }

        // Support for CORS
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, HEAD, OPTIONS, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Accept, Authorization");
        filterChain.doFilter(request, response);
    }
}
