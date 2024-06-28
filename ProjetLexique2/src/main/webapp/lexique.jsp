<%@ page import="org.example.projetlexique2.entity.Mot" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lexique du développeur</title>
    <style>
        .accordion-trigger {
            cursor: pointer;
            background-color: #f1f1f1;
            padding: 10px;
            margin: 5px 0;
            transition: background-color 0.3s;
        }

        .accordion-trigger:hover {
            background-color: #e0e0e0;
        }

        .accordion-trigger.active,
        .accordion-trigger:active {
            background-color: #ccc;
        }

        .definition {
            display: none;
            padding: 10px;
            border: 1px solid #ccc;
            border-top: none;
        }

        #filtre {
            list-style-type: none;
            padding: 0;
            display: flex;
        }

        #filtre li {
            margin-right: 10px;
            padding: 10px;
            border: 1px solid black;
            display: inline-block;
            box-sizing: border-box;
        }

        #filtre li a {
            text-decoration: none;
            color: #000;
            transition: background-color 0.3s, color 0.3s;
            display: block;
            padding: 10px;
            box-sizing: border-box;
        }

        #filtre li a:hover {
            background-color: blueviolet;
            color: rgba(241, 241, 241, 0.91);
        }

        #filtre li a:active {
            color: rebeccapurple;
            font-weight:bold ;
        }
    </style>
</head>
<body>
<p>Bienvenue sur ce site qui vous propose des quiz et des définitions ayant trait au monde du développement et, plus largement, au monde informatique</p>
<br/>

<!-- Barre de filtre alphabétique -->
<div>
    <ul id="filtre">
        <% for (char c = 'A'; c <= 'Z'; c++) { %>
        <li><a href="?letter=<%= c %>"><%= c %></a></li>
        <% } %>
    </ul>
</div>

<%
    // Récupération de la liste de mots depuis la session
    List<Mot> mots = (List<Mot>) session.getAttribute("mots");
    if (mots != null) {
        for (Mot mot : mots) {
%>
<!-- Affichage des mots et définitions -->
<h2 class="accordion-trigger"><%= mot.getMot().toUpperCase() %></h2>
<div class="definition">
    <h3>Définition :</h3>
    <p><%= mot.getDefinition() %></p>
    <% if (mot.getExemple() != null) { %>
    <h4>Exemple :</h4>
    <p><%= mot.getExemple() %></p>
    <% } %>
    <% if (mot.getImage() != null) { %>
    <img src="<%= mot.getImage() %>" alt="image d'exemple">
    <% } %>
</div>
<%
        }
    }
%>

<!-- Accordéon pour afficher les définitions -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        $('.definition').hide(); // Cacher toutes les définitions par défaut
        $('.accordion-trigger').click(function() {
            $(this).next('.definition').slideToggle();
        });

        // Ajouter et supprimer la classe 'active' pour le style de clic
        $('.accordion-trigger').on('click', function() {
            $('.accordion-trigger').removeClass('active');
            $(this).addClass('active');
        });
    });
</script>

</body>
</html>
