package com.yujia.wiki_spring.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class LogFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger( LogFilter.class );

    @Override
 public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
 public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
     HttpServletRequest request = (HttpServletRequest) servletRequest;
     log.info("------------- LogFilter Start -------------");
     log.info("Request Address: {} {}", request.getRequestURL().toString(), request.getMethod());
     log.info("Remote Address: {}", request.getRemoteAddr());

     long startTime = System.currentTimeMillis();
     filterChain.doFilter(servletRequest, servletResponse);
     log.info("------------- LogFilter End Runtime：{} ms -------------", System.currentTimeMillis() - startTime);
 }
}
