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

@WebServlet(name = "recherche1Acteur", value = "/recherche1Acteur")
public class Recherche1ActeurServlet extends HttpServlet {
    private ActorDAO actorDAO = new ActorDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        Actor actor = actorDAO.getActorById(id);
        request.setAttribute("actor", actor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("affiche1Acteur.jsp");
        dispatcher.forward(request, response);
    }


}
