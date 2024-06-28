package org.example.filtre_servlet.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // récupère la session existante --> false : si elle n'existe pas n'en créée pas une
        if (session != null) {
            session.invalidate(); // invalide la session --> la détruit côté serveur
        }

        // Supprime le cookie de session
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    cookie.setMaxAge(0); // Définir la durée de vie à zéro pour le supprimer
                    cookie.setPath(request.getContextPath());
                    response.addCookie(cookie); // Ajouter le cookie à la réponse pour le supprimer
                    break;
                }
            }
        }

        // Redirection sans création de nouvelle session
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//        response.setDateHeader("Expires", 0); // Proxies.
        response.sendRedirect(request.getContextPath() + "/index.jsp"); // Redirection

    }
}
