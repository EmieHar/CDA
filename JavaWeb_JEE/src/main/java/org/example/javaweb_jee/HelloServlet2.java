package org.example.javaweb_jee;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet2", value = "/helloServlet2")
public class HelloServlet2 extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");//traite les requêtes réponse

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        HttpSession session = request.getSession();//utilise la session dans l'entête de la requète
        String codeSession = session.getId();
       String person = (String) session.getAttribute("user"); //(String) --> caster /on change le format du getAttribute.
        out.println("<h2> L'id de la session est: " + codeSession + "</h2>");
        out.println("<h2>Nom de l'utilisateur de la session: " + person + "</h2>");

        out.println("</body></html>");

    }

    public void destroy() {
    }
}