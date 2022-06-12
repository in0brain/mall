package pers.lnz.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pers.lnz.entity.User;

import java.io.IOException;

public class MyFilter implements Filter {

//    private String excludePage;
//    private String[] excludePages;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response  = (HttpServletResponse) servletResponse;

            if(request.getSession().getAttribute("user")==null){
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                filterChain.doFilter(request,response);
            }
    }

    @Override
    public void destroy() {

    }
}
