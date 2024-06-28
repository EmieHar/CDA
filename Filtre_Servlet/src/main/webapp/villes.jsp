<%@ page import="org.example.filtre_servlet.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Emili
  Date: 18/06/2024
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<meta charset="UTF-8">
<%
    request.setAttribute("title", "Page Villes");
%>
<%@include file="Partials/head.jsp"%>


<%@ include file="Partials/log.jsp" %>

<body>
<%
    String[] cities = {"Mumbai", "Singapore", "Philadelphia"};
    pageContext.setAttribute("myCities",cities);
%>
<c:out value="Bonjour" />
<br/><br/>
<c:forEach var="city" items="${myCities}">
    ${city} <br />
</c:forEach>
<br/><br/>
<c:choose>
    <c:when test="${user.role == 'ADMIN'}">
        Bonjour Monsieur l'Admin
    </c:when>
    <c:when test="${user.role == 'USER'}">
        Bonjour Madame l'user
    </c:when>
    <c:otherwise>
        Bonjour
    </c:otherwise>
</c:choose>

<h2>Exemples de JSTL vs JSP</h2>

<h3>Affichage de Variables</h3>
<%-- Scriptlet --%>
<%= user.getEmail() %>

<%-- JSTL --%>
${user.email}

<h3>Boucles</h3>
<%-- Scriptlet --%>
<%
    List<Product> products = (List<Product>) session.getAttribute("products");
    for(Product product : products) {
%>
<h2><%= product.getNom_produit() %></h2>
<%
    }
%>

<%-- JSTL --%>
<c:forEach var="product" items="${products}">
    <h2>${product.nom_produit}</h2>
</c:forEach>
</body>
</html>

<h3>Conditions</h3>
<%-- Scriptlet --%>
<%
    if (user != null) {
%>
<p>Welcome, <%= user.getEmail() %></p>
<%
} else {
%>
<p>Please log in.</p>
<%
    }
%>

<%-- JSTL --%>
<c:choose>
    <c:when test="${user != null}">
        <p>Welcome, ${user.email}</p>
    </c:when>
    <c:otherwise>
        <p>Please log in.</p>
    </c:otherwise>
</c:choose>

<h3>Internationalisation</h3>


<%-- Scriptlet --%>
<%= bundle.getString("welcome.message") %>

<%-- JSTL --%>
<fmt:bundle basename="messages">
    <fmt:message key="welcome.message" />
</fmt:bundle>

