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
import java.util.List;

@WebServlet(name = "getServlet", value = "/getServlet")
public class GetServlet extends HttpServlet {
    private ActorDAO actorDAO = new ActorDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Actor> actors = actorDAO.getActors();
        request.setAttribute("actors", actors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("afficheActors.jsp");
        dispatcher.forward(request, response);
    }
}
