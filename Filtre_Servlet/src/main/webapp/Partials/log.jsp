<%@ page import="org.example.filtre_servlet.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- Created by IntelliJ IDEA. --%>


<nav id="deco">
    <% User user = (User) session.getAttribute("user");
        if(user != null){
    %>
    <form action="<%=request.getContextPath()%>/logout" method="post">
        <button type="submit">Se déconnecter</button>
    </form>
    <%
    } else{
    %>
    <form action="<%=request.getContextPath()%>/login.jsp" method="get">
        <button type="submit">Se connecter</button>
    </form>
    <%
        }
    %>
</nav>
