<%--
  Created by IntelliJ IDEA.
  User: Emili
  Date: 17/06/2024
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">

<%
    request.setAttribute("title", "Login Page");
%>
<%@include file="Partials/head.jsp"%>
<body>
<h2>Veuillez vous connecter pour avoir accès à l'application</h2>
<form action="<%= request.getContextPath() %>/loginServlet" method="post">
    <label for="email">Votre email</label>
    <input type="text" id="email" name="email">

    <label for="password">Votre mot de passe</label>
    <input type="text" name="password" id="password">

    <input type="submit" value="Se connecter">
</form>
</body>
</html>
