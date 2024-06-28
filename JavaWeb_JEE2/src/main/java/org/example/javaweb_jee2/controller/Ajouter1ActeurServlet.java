package org.example.javaweb_jee2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.javaweb_jee2.dao.ActorDAO;
import org.example.javaweb_jee2.model.Actor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet(name = "ajouter1Acteur", value = "/ajouter1Acteur")
public class Ajouter1ActeurServlet extends HttpServlet {
    private ActorDAO actorDAO = new ActorDAO();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String photo = request.getParameter("photo");

        Actor actor = new Actor(nom, prenom, photo);

        // Appeler la méthode DAO pour créer l'acteur dans la base de données
        boolean isActorCreated = actorDAO.createActor(actor);

//       if (isActorCreated) {
//           request.setAttribute("isActorCreated", isActorCreated);
//           response.sendRedirect(request.getContextPath() + "/ajouter1Acteur.jsp");
////           RequestDispatcher dispatcher = request.getRequestDispatcher("ajouter1Acteur.jsp");
////           dispatcher.forward(request, response);
//       }

        if (isActorCreated) {
            response.sendRedirect(request.getContextPath() + "/ajouter1Acteur.jsp?isActorCreated=true");
        } else {
            response.sendRedirect(request.getContextPath() + "/ajouter1Acteur.jsp?isActorCreated=false");
        }

    }

}





