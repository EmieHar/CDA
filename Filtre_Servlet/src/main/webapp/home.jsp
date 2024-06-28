<%@ page import="org.example.filtre_servlet.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Emili
  Date: 17/06/2024
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<h1>Bienvenue</h1>
<%
    User someUser = (User)session.getAttribute("user");
    if(someUser != null) {
        String username = someUser.getEmail();
        out.println("<h2>"+username+"</h2>");
    }
%>
</body>
</html>
