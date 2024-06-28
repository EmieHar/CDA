<%--
  Created by IntelliJ IDEA.
  User: Emili
  Date: 12/06/2024
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Welcome</h2>
<%
    String email = (String) session.getAttribute("email");
    String password = (String) session.getAttribute("password");
    if (email != null) {
        out.println("Hello, " + email);
        out.println("<br> Password:  " + password);
    } else {
        response.sendRedirect("login.jsp");
    }
%>
</body>
</html>
