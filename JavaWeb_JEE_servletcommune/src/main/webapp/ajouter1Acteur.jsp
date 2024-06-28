<%--
  Created by IntelliJ IDEA.
  User: Emili
  Date: 13/06/2024
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un acteur</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/actor/create" enctype="multipart/form-data">
    <label for="nom">Entrer le nom de l'acteur</label>
    <input type="text" id="nom" name="nom" required>
    <label for="prenom">Entrer le prénom de l'acteur</label>
    <input type="text" id="prenom" name="prenom" required>
    <label for="photo">Sélectionner la photo de l'acteur</label>
    <input type="file" id="photo" name="photo" required>
    <input type="submit" value="Créer un nouvel acteur">
</form>

<%
    String isActorCreated = request.getParameter("isActorCreated");
    if ("true".equals(isActorCreated)) {
%>
<h2>Acteur créé avec succès</h2>
<%
} else if ("false".equals(isActorCreated)) {
%>
<h2>Erreur lors de la création de l'acteur</h2>
<%
    }
%>

</body>
</html>
