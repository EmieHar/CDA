<%--
  Created by IntelliJ IDEA.
  User: Emili
  Date: 12/06/2024
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Formulaire de connexion</h2>
<form action="login" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>
    <input type="submit" value="Se connecter">
</form>

<%
    String error = request.getParameter("error");
    if ("invalid".equals(error)) {
%>
<p style="color:red;">Erreur d'authentification: Email ou mot de passe invalide<br>Veuillez essayer à nouveau</p>
<%
    }
%>
</body>
</html>
