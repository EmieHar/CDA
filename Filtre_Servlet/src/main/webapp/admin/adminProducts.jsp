<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="org.example.filtre_servlet.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.filtre_servlet.utils.MessageUtils" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- Created by IntelliJ IDEA. User: Emili Date: 17/06/2024 Time: 13:52 To change this template use File | Settings | File Templates. --%>
<!DOCTYPE html>
<html lang="fr">

<head>
    <title>Page d'accueil</title>
    <%@ include file="../Partials/head.jsp" %>
</head>
<body>
<%@ include file="../Partials/log.jsp" %>

<%
    List<Product> products = (List<Product>) session.getAttribute("products");

    Boolean isCreated = (Boolean) session.getAttribute("success");
    Boolean isUpdated = (Boolean) session.getAttribute("successUpdate");
    Boolean isDeleted = (Boolean) session.getAttribute("successDelete");
%>

<h1>Bienvenue sur la page de Gestion des produits Admin: <%= user.getEmail() %></h1>
<div id="messagesDiv">
    <h3><%= MessageUtils.getSuccessMessage(isCreated, isUpdated, isDeleted) %></h3>
</div>
<div>
    <button id="create">Créer un produit</button>
    <div id="divCreate" class="hidden">
        <form action="<%= request.getContextPath() %>/adminProducts/createProduct" method="post">
            <label for="nomProduit">Nom du produit:</label>
            <input type="text" id="nomProduit" name="nomProduit"><br>
            <label for="description">Description du produit:</label>
            <input type="text" id="description" name="description"><br>
            <label for="photo">Photo du produit:</label>
            <input type="text" id="photo" name="photo"><br>
            <label for="prix">Prix du produit:</label>
            <input type="text" id="prix" name="prix"><br>
            <label for="stock">Stock:</label>
            <input type="number" id="stock" name="stock"><br>
            <input type="submit" id="go" value="Créer le produit">
        </form>
    </div>
</div>
<br>
<div>

    <!--Code Remplacé par JSTL

    <c:set var="products" value="${sessionScope.products}" />
    <c:set var="isCreated" value="${sessionScope.success}" />
    <c:set var="isUpdated" value="${sessionScope.successUpdate}" />
    <c:set var="isDeleted" value="${sessionScope.successDelete}" />

    <div id="messagesDiv">
        <h3>${fn:escapeXml(MessageUtils.getSuccessMessage(isCreated, isUpdated, isDeleted))}</h3>
    </div>
    <ul id="listProducts" class="hidden">
        <c:if test="${not empty products}">
            <c:forEach var="product" items="${products}">
                <li>
                    <h2>${product.nom_produit}</h2>
                    <p>${product.photo}</p>
                    <p>${product.description}</p>
                    <h3>Prix à l'unité: ${product.prix}</h3>
                    <p>En stock: ${product.stock}<p>
                </li>
            </c:forEach>
        </c:if>
    </ul>-->

    <button id="getList">Afficher la liste des produits</button>
    <ul id="listProducts" class="hidden">
        <% if (products != null) {
            for (Product product : products) { %>
        <li>
            <h2><%= product.getNom_produit() %></h2>
            <p><%= product.getPhoto() %></p>
            <p><%= product.getDescription() %></p>
            <h3>Prix à l'unité: <%= product.getPrix() %></h3>
            <p>En stock: <%=product.getStock()%></p>

            <!-- Formulaire de modification pour chaque produit -->
            <h2>Modification du produit:</h2>
            <form action="<%= request.getContextPath() %>/adminProducts/modifyProduct" method="post">
                <input type="hidden" name="productId" value="<%= product.getIdProduct() %>">
                <label for="modifNomProduit">Nom du produit:</label>
                <input type="text" id="modifNomProduit" name="modifNomProduit" value="<%= product.getNom_produit() %>"><br>
                <label for="modifDescription">Description du produit:</label>
                <input type="text" id="modifDescription" name="modifDescription" value="<%= product.getDescription() %>"><br>
                <label for="modifPhoto">Photo du produit:</label>
                <input type="text" id="modifPhoto" name="modifPhoto" value="<%= product.getPhoto() %>"><br>
                <label for="modifPrix">Prix du produit:</label>
                <input type="text" id="modifPrix" name="modifPrix" value="<%= product.getPrix() %>"><br>
                <label for="modifStock">Produit en stock:</label>
                <input type="number" id="modifStock" name="modifStock" value="<%= product.getStock() %>"><br>
                <input type="submit" value="Enregistrer les modifications">
            </form>
            <br>
            <form action="<%= request.getContextPath() %>/adminProducts/supprProduct" method="post">
                <input type="hidden" name="productId" value="<%= product.getIdProduct() %>">
                <input type="submit" value="Supprimer le produit">
            </form>
        </li>
        <% }
        } %>
    </ul>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        const buttonCreate = document.getElementById("create");
        const button = document.getElementById("getList");

        const divCreate = document.getElementById("divCreate");
        const productList = document.getElementById("listProducts");

        buttonCreate.addEventListener("click", function() {
            divCreate.classList.toggle("hidden");
        });

        button.addEventListener("click", function() {
            productList.classList.toggle("hidden");
        });
    });
</script>
<style>
    .hidden {
        display: none;
    }
</style>

</body>
</html>
