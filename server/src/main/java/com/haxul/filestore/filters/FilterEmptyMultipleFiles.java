package com.haxul.filestore.filters;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class FilterEmptyMultipleFiles implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String contentTypeHeader = httpRequest.getHeader("content-type");
        Pattern formPattern = Pattern.compile("multipart/form-data");
        Matcher formMatcher = formPattern.matcher(contentTypeHeader);
        Boolean isMultipartForm = formMatcher.find();
        if (!isMultipartForm) filterChain.doFilter(servletRequest, servletResponse);
        Pattern boundaryPattern = Pattern.compile("boundary");
        Matcher boundaryMatcher = boundaryPattern.matcher(contentTypeHeader);
        boolean hasBoundary = boundaryMatcher.find();
        if (hasBoundary) filterChain.doFilter(servletRequest, servletResponse);
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setStatus(400);
    }
    @Override
    public void destroy() {

    }
}
