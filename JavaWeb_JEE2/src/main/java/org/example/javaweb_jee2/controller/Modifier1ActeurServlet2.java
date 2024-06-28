package org.example.javaweb_jee2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.javaweb_jee2.dao.ActorDAO;
import org.example.javaweb_jee2.model.Actor;

import java.io.IOException;

@WebServlet(name = "modifier1Acteur2", value = "/modifier1Acteur2")
public class Modifier1ActeurServlet2 extends HttpServlet {
    private ActorDAO actorDAO = new ActorDAO();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String photo = request.getParameter("photo");

        Actor actor = new Actor(nom, prenom, photo);
        actorDAO.updateActor(id, actor);

        request.setAttribute("actormodified", true);
        request.setAttribute("actor", actor);

        RequestDispatcher dispatcher = request.getRequestDispatcher("modifier1Acteur.jsp");
        dispatcher.forward(request, response);
    }
}
