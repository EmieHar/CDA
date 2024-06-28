<%@ page import="org.example.filtre_servlet.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><%--
  Created by IntelliJ IDEA.
  User: Emili
  Date: 17/06/2024
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="fr">

<%
    request.setAttribute("title", "Liste des Produits");
%>
<%@include file="../Partials/head.jsp"%>

<%@include file="../Partials/log.jsp" %>
<body>

<h1>Liste des produits</h1>

<%
    if (user!=null){ %>

    <ul>
    <%
        List<Product> products = (List<Product>) session.getAttribute("products");
        for (Product product : products) {
    %>
    <li>
        <h2><%= product.getNom_produit()%></h2>
        <p><%=product.getPhoto()%></p>
        <p><%= product.getDescription()%></p>
        <h3>prix à l'unité: <%=product.getPrix()%></h3>
        <p>En stock: <%=product.getStock()%></p>

        <form action="/ajouterPanier" method="post">
            <input type="hidden" value="<%= product.getIdProduct()%>">
            <label for="quantity"> Saisir la quantité souhaitée:</label>
            <input type="number" id="quantity" name="quantity" value="1" min="1" max="100">

            <input type="submit" value="ajouter au panier">
        </form>
    </li>
    <%
        }
    %>
    </ul>
<% }else{ %>
 <p> vous devez être connecté pour accéder aux produits</p>
    <a href="<%= request.getContextPath() %>/login.jsp">Se connecter</a>
<%
    }
%>


</body>
</html>
