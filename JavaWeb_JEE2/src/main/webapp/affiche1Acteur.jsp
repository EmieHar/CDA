<%@ page import="org.example.javaweb_jee2.model.Actor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Affichage d'un acteur</title>
</head>
<body>
<h2> Afficher l'acteur qui correspond un id donné</h2>
<form action="recherche1Acteur" method="get">
    <label for="id">Entrez un chiffre:</label>
    <input type="number" id="id" name="id" required><br><br>

    <input type="submit" value="Soumettre l'id">
</form>
<%
    Actor actor = (Actor) request.getAttribute("actor");
    if (actor != null) {

%>
    <h2>L'acteur correspondant à l'id : <%= actor.getId()%> est:</h2>
    <h2>- Nom: <%= actor.getNom() %> Prénom: <%= actor.getPrenom() %></h2>

<%

} else {
%>
<p>Aucun acteur trouvé.</p>
<%
    }
%>
</body>
</html>
