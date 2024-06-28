<%--
  Created by IntelliJ IDEA.
  User: Emili
  Date: 11/06/2024
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<% String titre = "la request";%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP3</title>
</head>
<%@include file="JSP4.jsp"%>
<body>

<h1>JSP3</h1>
METHOD : <%= request.getMethod() %><br>
Parameter: nom = <%= request.getParameter("nom")%> <br>
PATH INFO : <%= request.getPathInfo()%><br>
HOST: <%= request.getRemoteHost()%> <br>
PORT: <%= request.getRemotePort()%><br>

</body>
</html>
