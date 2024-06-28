<%--
  Created by IntelliJ IDEA.
  User: Emili
  Date: 11/06/2024
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP2</title>
</head>
<body>
<h1>JSP2</h1>
<table>
<%
    String color;
    boolean paire = true;

    for (int i=1; i<4; i++){
        for(int j = 1; j<4; j++){
            if(paire) {color ="#FF0000";}
            else {color ="#0000FF";}
            paire = !paire;
%>
<tr bgcolor =<%= color%>>
    <td> <%= i%> * <%= j%></td>
    <td> <%= i * j%></td>
</tr>
<%
        }
    }
%>
</table>
</body>
</html>
