<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <%
        request.setAttribute("title", "Page d'accueil");
    %>
    <%@include file="Partials/head.jsp"%>
</head>
<body>
<%@ include file="Partials/log.jsp" %>
<h1>Bienvenue sur mon appli</h1>
<br/>
<a href="<%=request.getContextPath()%>/listProducts">Accéder aux produits</a>
<br/>
<br/>
<a href="<%=request.getContextPath()%>/villes.jsp">villes</a>
</body>
</html>
