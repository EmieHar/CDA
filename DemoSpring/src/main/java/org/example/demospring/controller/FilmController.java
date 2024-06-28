package org.example.demospring.controller;

import org.example.demospring.model.Acteur;
import org.example.demospring.model.Film;
import org.example.demospring.model.Genre;
import org.example.demospring.model.Real;
import org.example.demospring.service.ActeurService;
import org.example.demospring.service.FilmService;
import org.example.demospring.service.GenreService;
import org.example.demospring.service.RealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping("film")
public class FilmController {


    @Autowired
    private FilmService filmService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private RealService realService;

    @Autowired
    private ActeurService acteurService;

    private static final Logger logger = LoggerFactory.getLogger(org.example.demospring.controller.ActeurController.class);

    @Value("${upload.path}")
    private String uploadPath;


    @GetMapping("/list")
    public String listFilm(Model model) {
        List<Film> films = filmService.findAll();
        model.addAttribute("films", films);
        return ("films");
    }

    @GetMapping("/{id}")
    public String getFilm(@PathVariable("id") int id, Model model) {
        Optional<Film> filmOpt = filmService.getOne(id);
        if (filmOpt.isPresent()) {
            model.addAttribute("film", filmOpt.get());
            return "film";
        } else {
            // Gérer le cas où le film n'est pas trouvé
            return "erreur";
        }
    }

    @GetMapping("/create")
    public String createFilmForm(Model model) {
        Film film = new Film();
        List<Genre> genres = genreService.findAll();
        List<Real> reals = realService.findAll();
        List<Acteur> acteurs = acteurService.findAll();
        model.addAttribute("film", film);
        model.addAttribute("genres", genres);
        model.addAttribute("reals", reals);
        model.addAttribute("acteurs", acteurs);
        return "createFilm";
    }

    @PostMapping("/create")
    public String createFilm(@ModelAttribute("film") Film film,
                             @ModelAttribute("real") Real real,
                             @ModelAttribute("genre") Genre genre,
                             @RequestParam(value = "acteurIds", required = false) List<Integer> acteurIds,
                             @RequestParam("afficheFile") MultipartFile afficheFile,
                             RedirectAttributes redirectAttributes) {

        // Vérifiez si le réalisateur et le genre ne sont pas nuls
        if (real == null || genre == null) {
            // Gérez le cas où realId ou genreId n'existe pas dans la base de données
            throw new IllegalArgumentException("Invalid real or genre provided.");
        }

        // Définir le Real et le Genre récupérés sur le Film
        film.setReal(real);
        film.setGenre(genre);

        // Définir les Acteurs sélectionnés pour le Film
        if (acteurIds != null && !acteurIds.isEmpty()) {
            Set<Acteur> acteurs = new HashSet<>(acteurService.findAllById(acteurIds));
            film.setActeurs(acteurs);
        }

        // Gestion de l'affiche du film
        if (!afficheFile.isEmpty()) {
            try {
                // Générer un identifiant unique pour le nom du fichier
                String uniqueId = UUID.randomUUID().toString();

                // Obtenir l'extension du fichier d'origine
                String originalFilename = afficheFile.getOriginalFilename();
                String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));

                // Construire le nouveau nom de fichier avec le titre du film, identifiant unique et extension
                String newFileName = film.getTitre().toLowerCase().replaceAll("\\s+", "") + "_" + uniqueId + fileExtension;

                // Définir le chemin où enregistrer le fichier d'affiche avec le nouveau nom
                Path path = Paths.get(uploadPath, newFileName);

                // Écrire les bytes du fichier dans le chemin spécifié
                Files.write(path, afficheFile.getBytes());

                // Associer le nouveau nom de fichier à l'entité Film
                film.setAffiche(newFileName);

            } catch (IOException e) {
                e.printStackTrace();
                // Gérez les erreurs liées à la sauvegarde du fichier
                redirectAttributes.addFlashAttribute("error", "Erreur lors de l'upload de l'affiche.");
                return "redirect:/film/create";
            }
        }

        // Sauvegarde du Film
        filmService.save(film);
        return "redirect:/film/list";
    }



    @GetMapping("/update/{id}")
    public String updateFilmForm(@PathVariable("id") int id, Model model) {
        Optional<Film> optionalFilm = filmService.getOne(id);
        if (optionalFilm.isPresent()) {
            Film film = optionalFilm.get();
            List<Genre> genres = genreService.findAll();
            List<Real> reals = realService.findAll();
            List<Acteur> acteurs = acteurService.findAll();
            model.addAttribute("film", film);
            model.addAttribute("genres", genres);
            model.addAttribute("reals", reals);
            model.addAttribute("acteurs", acteurs);
            return "updateFilm";
        } else {
            return "erreur";
        }
    }


    @PostMapping("/update")
    public String updateFilm(@ModelAttribute("film") Film film,
                             @ModelAttribute("real") Real real,
                             @ModelAttribute("genre") Genre genre,
                             @RequestParam(value = "acteurIds", required = false) List<Integer> acteurIds,
                             @RequestParam("afficheFile") MultipartFile afficheFile,
                             RedirectAttributes redirectAttributes) {

        if (real == null || genre == null) {
            // Handle the case where realId or genreId does not exist in the database
            throw new IllegalArgumentException("Invalid real or genre provided.");
        }

        film.setGenre(genre);
        film.setReal(real);

        if (acteurIds != null && !acteurIds.isEmpty()) {
            Set<Acteur> acteurs = new HashSet<>(acteurService.findAllById(acteurIds));
            film.setActeurs(acteurs);
        }

        // Gestion de l'affiche du film
        if (!afficheFile.isEmpty()) {
            try {
                // Générer un identifiant unique pour le nom du fichier
                String uniqueId = UUID.randomUUID().toString();

                // Obtenir l'extension du fichier d'origine
                String originalFilename = afficheFile.getOriginalFilename();
                String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));

                // Construire le nouveau nom de fichier avec le titre du film, identifiant unique et extension
                String newFileName = film.getTitre().toLowerCase().replaceAll("\\s+", "") + "_" + uniqueId + fileExtension;

                // Définir le chemin où enregistrer le fichier d'affiche avec le nouveau nom
                Path path = Paths.get(uploadPath + File.separator + newFileName);

                // Écrire les bytes du fichier dans le chemin spécifié
                Files.write(path, afficheFile.getBytes());

                // Associer le nouveau nom de fichier à l'entité Film
                film.setAffiche(newFileName);

            } catch (IOException e) {
                e.printStackTrace();
                // Gérer les erreurs correctement
                redirectAttributes.addFlashAttribute("error", "Erreur lors de l'upload de l'affiche.");
                return "redirect:/film/update/" + film.getId();
            }
        }

        // Sauvegarde du Film
        filmService.save(film);
        return "redirect:/film/list";
    }


    @GetMapping("/delete/{id}")
    public String deleteFilm(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        boolean success = filmService.deleteFilm(id);
        if (success) {
            redirectAttributes.addFlashAttribute("message", "Film supprimé avec succès!");
            logger.info("Film with id {} deleted successfully.", id);
        } else {
            redirectAttributes.addFlashAttribute("error", "Film introuvable!");
            logger.warn("Film with id {} not found.", id);
        }
        return "redirect:/film/list";
    }

}




