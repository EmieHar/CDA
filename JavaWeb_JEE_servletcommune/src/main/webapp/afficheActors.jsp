
<%@ page import="java.util.List" %>
<%@ page import="org.example.javaweb_jee_servletcommune.model.Actor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Acteurs</title>
</head>
<body>
<h2> Liste des Acteurs</h2>
<%
    List<Actor> actors = (List<Actor>) request.getAttribute("actors");
    if (actors != null) {
        for (Actor actor : actors) {
%>
<ul>
    <li>Nom: <%= actor.getNom() %> Prénom: <%= actor.getPrenom() %></li>
</ul>
<%
    }
} else {
%>
<p>Aucun acteur trouvé.</p>
<%
    }
%>
</body>
</html>
