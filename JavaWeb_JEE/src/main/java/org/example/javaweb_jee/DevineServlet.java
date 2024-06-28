package org.example.javaweb_jee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "devineServlet", value = "/devineServlet")

public class DevineServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        //récupération du paramètre
        Integer i = Integer.valueOf(request.getParameter("guess"));
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + i + "</h1>");
        out.println("</body></html>");
    }

}
