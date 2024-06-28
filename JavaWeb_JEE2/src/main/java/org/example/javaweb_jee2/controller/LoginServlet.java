package org.example.javaweb_jee2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;
import org.example.javaweb_jee2.model.Admin;
import util.PasswordUtil;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Admin admin;

    public void init(){
        admin = new Admin("admin@gmail.fr", "password");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //récupération des variables de connection
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        //hashage mdp
        String hashPassword = PasswordUtil.hashPassword(password);

        //comparaison et actions en conséquences

        if (email.equals(admin.getEmail()) && PasswordUtil.checkPassword(password, admin.getPassword())) {

            // Création session et redirection vers page d'accueil
            HttpSession session = request.getSession();
            session.setAttribute("email", email);//enregistre dans la session
            session.setAttribute("password", hashPassword);
        // response.sendRedirect("welcome.jsp");//redirige vers la page choisie

            // Forward to welcome.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("/hello-servlet");
            dispatcher.forward(request, response);

        } else {
            // erreur donc redirection vers page connection avec message d'erreur
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}
