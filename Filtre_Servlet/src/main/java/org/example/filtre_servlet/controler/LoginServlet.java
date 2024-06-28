package org.example.filtre_servlet.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.filtre_servlet.model.User;
import org.example.filtre_servlet.model.dao.UserDAO;

import java.io.IOException;


@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO= new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email != null && password != null) {
            User user = userDAO.getUser(email);

            if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                    response.sendRedirect(request.getContextPath() + "/listProducts");

            } else {
                response.sendRedirect("err.jsp");
                System.out.println("Erreur : email ou mot de passe incorrect.");
            }
        } else {
            response.sendRedirect("err.jsp");
            System.out.println("Erreur : email ou mot de passe manquant.");
        }
    }

    @Override
    public void init() {
        // Initialisation si nécessaire
    }

    @Override
    public void destroy() {
        // Nettoyage si nécessaire
    }

}
