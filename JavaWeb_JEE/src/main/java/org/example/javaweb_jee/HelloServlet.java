package org.example.javaweb_jee;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }//initialises le message

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");//traite les requêtes réponse

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<a href=\"index.jsp\">");
        out.println("<img src=\"images/return.gif\" height=24 " +
                "width=24 align=right border=0 alt=\"return\"></a>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        HttpSession session = request.getSession();//utilise la session dans l'entête de la requète

        session.setAttribute("user", "inox");

        RequestDispatcher rd = request.getRequestDispatcher("helloServlet2");
        rd.forward(request, response);


    }

    public void destroy() {
    }
}