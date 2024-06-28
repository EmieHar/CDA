<%@ page import="java.util.List" %>
<%@ page import="org.example.javaweb_jee_servletcommune.model.Actor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier un acteur</title>
</head>
<body>
<h2> Cochez l'acteur à modifier</h2>
<form action="<%= request.getContextPath() %>/actor/modifier1Acteur" method="post">
    <% List<Actor> actors = (List<Actor>) request.getAttribute("actors2");
        if (actors != null) {
            for (Actor actor : actors) { %>
    <input type="checkbox" name="selectedActor" value="<%= actor.getId() %>">
    <%= actor.getNom() %> <%= actor.getPrenom() %><br>
    <% }} %>
    <br>
    <input type="submit" value="Modifier l'acteur sélectionné">
</form>

<%
    Actor selectedActor = (Actor) request.getAttribute("actor");
    if (selectedActor != null) { %>
<h2>Modification de l'acteur sélectionné: <%= selectedActor.getNom() %> <%= selectedActor.getPrenom() %></h2>
<form action="<%= request.getContextPath() %>/actor/enregistrerModif" method="post">
    <input type="hidden" name="id" value="<%= selectedActor.getId() %>">

    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom" value="<%= selectedActor.getNom() %>"><br>
    <label for="prenom">Prénom:</label>
    <input type="text" id="prenom" name="prenom" value="<%= selectedActor.getPrenom() %>"><br>
    <label for="photo">Photo:</label>
    <input type="text" id="photo" name="photo" value="<%= selectedActor.getPhoto() %>"><br>
    <!-- Autres champs à modifier -->
    <input type="submit" value="Enregistrer les modifications">
</form>
<% } %>
<%
    Boolean isActorModified = (Boolean) request.getAttribute("actormodified");
    if (isActorModified != null && isActorModified) { %>
<h2>L'acteur <%= selectedActor.getNom() %> <%= selectedActor.getPrenom() %> a été modifié avec succès.</h2>
<% } %>

</body>
</html>
