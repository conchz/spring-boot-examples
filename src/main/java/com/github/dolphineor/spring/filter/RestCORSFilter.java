package com.github.dolphineor.spring.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2015-09-12.
 * {@code RestCORSFilter} responds to all requests with certain Access-Control-* headers.
 *
 * @author dolphineor
 */
@Configuration
public class RestCORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse _servletResponse = (HttpServletResponse) servletResponse;
        _servletResponse.setHeader("Access-Control-Allow-Origin", "*");
        _servletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        _servletResponse.setHeader("Access-Control-Max-Age", "3600");
        _servletResponse.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Accept, Authorization");
        filterChain.doFilter(servletRequest, _servletResponse);
    }

    @Override
    public void destroy() {

    }
}
