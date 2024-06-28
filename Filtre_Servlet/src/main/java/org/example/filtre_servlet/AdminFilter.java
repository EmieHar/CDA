package org.example.filtre_servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.filtre_servlet.model.User;

import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Je filtre sur le request admin");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false); // false -> ne pas créer de session si elle n'existe pas

        if (session != null) {
            User user = (User) session.getAttribute("user");

            if (user != null) {
                System.out.println("Session dans le filtre admin : " + user.getEmail());

                if ("ADMIN".equals(user.getRole())) {
                    System.out.println("User is admin: true");
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                } else {
                    System.out.println("User is admin: false");
                }
            } else {
                System.out.println("Pas de user admin");
            }
        } else {
            System.out.println("Pas de session");
        }

        // Redirection vers la page d'erreur si l'utilisateur n'est pas admin
        System.out.println("Je filtre sur la response - redirection vers err.jsp");
        response.sendRedirect(request.getContextPath() + "/err.jsp");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}