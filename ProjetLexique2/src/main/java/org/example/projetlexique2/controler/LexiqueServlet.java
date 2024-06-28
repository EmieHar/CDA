package org.example.projetlexique2.controler;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.example.projetlexique2.dao.LexiqueDAO;
import org.example.projetlexique2.entity.Mot;


@WebServlet("/lexique")
public class LexiqueServlet extends HttpServlet {
    private LexiqueDAO lexiqueDAO = new LexiqueDAO();

    public void init() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code pour récupérer la liste de mots depuis votre DAO ou service
        List<Mot> mots = lexiqueDAO.getMots();

        // Récupérer le paramètre "letter" de la requête pour le filtrage
        String letter = request.getParameter("letter");

        // Filtrer les mots par la lettre si le paramètre est présent
        if (letter != null && !letter.isEmpty()) {
            mots = mots.stream()
                    .filter(mot -> mot.getMot().toUpperCase().startsWith(letter.toUpperCase()))
                    .collect(Collectors.toList());
        }

        // Placer la liste filtrée dans la session
        HttpSession session = request.getSession();
        session.setAttribute("mots", mots);

        // Rediriger vers votre page JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/lexique.jsp");
        dispatcher.forward(request, response);
    }


    public void destroy() {
    }
}