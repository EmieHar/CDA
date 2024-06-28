<%--
  Created by IntelliJ IDEA.
  User: Emili
  Date: 13/06/2024
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>

<a href="<%= request.getContextPath() %>/actor/list">Afficher la liste des acteurs</a>
<br/>
<a href="affiche1Acteur.jsp">Afficher un acteur grâce à son id</a>
<br/>
<a href="<%= request.getContextPath() %>/actor/update">Modifier un acteur</a>
<br/>
<a href="ajouter1Acteur.jsp">Ajouter un acteur</a>
</body>
</html>
