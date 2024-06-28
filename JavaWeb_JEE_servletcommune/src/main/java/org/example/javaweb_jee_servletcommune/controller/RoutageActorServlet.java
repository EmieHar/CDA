package org.example.javaweb_jee_servletcommune.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import org.example.javaweb_jee_servletcommune.dao.ActorDAO;
import org.example.javaweb_jee_servletcommune.model.Actor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/actor/*")
@MultipartConfig
public class RoutageActorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ActorDAO actorDAO = new ActorDAO();
    private static final String UPLOAD_DIRECTORY = "C:\\Users\\Emili\\OneDrive\\Bureau\\CDA\\JAVA\\JavaWeb_JEE_servletcommune\\src\\main\\webapp\\uploads";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        String destination = null;

        if (path != null) {
            switch (path) {

                case "/list":
                    List<Actor> actors = actorDAO.getActors();
                    request.setAttribute("actors", actors);
                    RequestDispatcher listDispatcher = request.getRequestDispatcher("/afficheActors.jsp");
                    listDispatcher.forward(request, response);
                    break;

                case "/actor":
                    int id = Integer.parseInt(request.getParameter("id"));

                    Actor actor = actorDAO.getActorById(id);
                    request.setAttribute("actor", actor);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/affiche1Acteur.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "/update":
                    List<Actor> actors2 = actorDAO.getActors();
                    request.setAttribute("actors2", actors2);
                    RequestDispatcher listDispatcher2 = request.getRequestDispatcher("/modifier1Acteur.jsp");
                    listDispatcher2.forward(request, response);
                    break;

                default:
                    destination = "/error.jsp"; // Page d'erreur pour les chemins inconnus
                    break;
            }
        } else {
            destination = "/error.jsp"; // Page d'erreur pour un chemin null
        }

        if (destination != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        String destination = null;

        if (path != null) {
            switch (path) {
                case "/create":
                    Part filePart = request.getPart("photo");
                    String originalFileName = getFileName(filePart);

                    // Générer un nom de fichier unique
                    String todayDate = LocalDate.now().toString(); // Date du jour
                    String nomActeur = request.getParameter("nom");
                    String prenomActeur = request.getParameter("prenom");

                            // Remplacer les caractères spéciaux et espaces dans les noms
                    String fileName = nomActeur +"_"+ prenomActeur + "_" + todayDate + ".png";
                    fileName = fileName.replaceAll("[^a-zA-Z0-9.-]", "_"); // Remplace les caractères spéciaux par _

                    // Obtenir le chemin dynamique de l'application
                    String applicationPath = getServletContext().getRealPath("");
                    String uploadPath = UPLOAD_DIRECTORY;

                    File uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdirs(); // Utilise mkdirs() pour créer les répertoires parents si nécessaire
                    }

                    try (InputStream fileContent = filePart.getInputStream()) {

                        // Écrire le fichier sur le disque
                        Path fileUploadPath = Paths.get(uploadPath, fileName);
                        Files.copy(fileContent, fileUploadPath, StandardCopyOption.REPLACE_EXISTING);

                        // Enregistrement de l'acteur dans la base de données avec le chemin relatif
                        String relativeFilePath = "/uploads/" + fileName;
                        Actor actorCreated = new Actor(nomActeur, prenomActeur, relativeFilePath);
                        boolean isActorCreated = actorDAO.createActor(actorCreated);

                        if (isActorCreated) {
                            response.sendRedirect(request.getContextPath() + "/ajouter1Acteur.jsp?isActorCreated=true");
                        } else {
                            response.sendRedirect(request.getContextPath() + "/ajouter1Acteur.jsp?isActorCreated=false");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        response.sendRedirect(request.getContextPath() + "/ajouter1Acteur.jsp?isActorCreated=false");
                    }
                    break;

                case "/modifier1Acteur":
                    int id = Integer.parseInt(request.getParameter("selectedActor"));
                    Actor actor = actorDAO.getActorById(id);
                    System.out.println(id);
                    request.setAttribute("actor", actor);
                    System.out.println(actor);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/modifier1Acteur.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "/enregistrerModif":
                    String idParam = request.getParameter("id");
                    int idModif = Integer.parseInt(idParam);
                    String nom = request.getParameter("nom");
                    String prenom = request.getParameter("prenom");
                    String photo = request.getParameter("photo");

                    Actor actorModif = new Actor(nom, prenom, photo);
                    boolean isActorModified = actorDAO.updateActor(idModif,actorModif);

                    request.setAttribute("actormodified", isActorModified);
                    request.setAttribute("actor", actorModif);

                    RequestDispatcher dispatcherModif = request.getRequestDispatcher("/modifier1Acteur.jsp");
                    dispatcherModif.forward(request, response);
                    break;


                default:
                    destination = "/error.jsp"; // Page d'erreur pour les chemins inconnus
                    break;
            }
        } else {
            destination = "/error.jsp"; // Page d'erreur pour un chemin null
        }

        if (destination != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
            dispatcher.forward(request, response);
        }
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "";
    }
}
