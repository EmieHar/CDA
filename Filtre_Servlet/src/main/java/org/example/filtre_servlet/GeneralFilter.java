//package org.example.filtre_servlet;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.example.filtre_servlet.model.User;
//
//import java.io.IOException;
//
//@WebFilter("/*")
//public class GeneralFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("je filtre sur le request");
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//
//        HttpSession session = request.getSession(false);//false --> ne pas créer de session si elle n'existe pas
//
//        if(session != null && session.getAttribute("user") != null){
//            User user = (User) session.getAttribute("user");
//            System.out.println("email du user: " + user.getEmail());
//        }
//
//
//        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("je filtre sur la response");
//    }
//
//
//    public void destroy(){
//        Filter.super.destroy();
//    }
//}
