package org.example.demospring.controller;

import org.example.demospring.model.Acteur;
import org.example.demospring.service.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("acteur")
public class ActeurController {

    @Autowired
    private ActeurService acteurService;

    private static final Logger logger = LoggerFactory.getLogger(ActeurController.class);

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/list")
    public String listActeur(Model model) {
        List<Acteur> acteurs = acteurService.findAll();
        model.addAttribute("acteurs", acteurs);
        return ("acteurs");// nom de la vue
    }

    @GetMapping("/getOne/{id}")
    public String getOneActeur(@PathVariable("id") int id, Model model) {
        Optional<Acteur> acteur= acteurService.getOne(id);
        model.addAttribute("acteur", acteur);
        return ("acteur");
    }

    @GetMapping("/create")
    public String createActeurForm(Model model) {
        Acteur acteur = new Acteur(); //pour que formulaire dispose d'un objet vide à remplir + éviter erreurs potentielles si les champs attendent un objet non nul.
        model.addAttribute("acteur", acteur);
        return "createActeur";
    }

    @PostMapping("/create")
    public String createActeur(@ModelAttribute("acteur") Acteur acteur,
                               BindingResult result,
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "createActeur"; // Retourner au formulaire en cas d'erreurs de validation
        }

        MultipartFile photoFile = acteur.getPhotoFile();
        if (photoFile != null && !photoFile.isEmpty()) {
            try {
                // Récupérer le nom de l'acteur et prénom de l'acteur
                String nomActeur = acteur.getNom();
                String prenomActeur = acteur.getPrenom();

                // Générer un identifiant unique pour le nom du fichier
                String uniqueId = UUID.randomUUID().toString();

                // Obtenir l'extension du fichier d'origine
                String originalFilename = photoFile.getOriginalFilename();
                String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));

                // Construire le nouveau nom de fichier avec le nom, prénom, identifiant unique et extension
                String newFileName = nomActeur.toLowerCase() + prenomActeur.toLowerCase() + "_" + uniqueId + fileExtension;

                // Lire les bytes du fichier de photo
                byte[] bytes = photoFile.getBytes();

                // Définir le chemin où enregistrer le fichier de photo avec le nouveau nom
                Path path = Paths.get(uploadPath + File.separator + newFileName);

                // Écrire les bytes du fichier dans le chemin spécifié
                Files.write(path, bytes);

                // Associer le nouveau nom de fichier à l'acteur
                acteur.setPhoto(newFileName);

            } catch (IOException e) {
                e.printStackTrace();

            }
        }

        // Sauvegarde l'acteur en base de données
        acteurService.save(acteur);

        // Redirection vers la liste des acteurs après la création
        return "redirect:/acteur/list";
    }



    @GetMapping("/update/{id}")
    public String updateActeurForm(@PathVariable("id") int id, Model model) {
        Optional<Acteur> optionalActeur = acteurService.getOne(id);
        if (optionalActeur.isPresent()) {
            Acteur acteur = optionalActeur.get();
            model.addAttribute("acteur", acteur);
            return "updateActeur";
        } else {
            // Gérer le cas où l'acteur n'est pas trouvé
            System.out.println("erreur");
            return "erreur";
        }
    }

    @PostMapping("/update")
    public String updateActeur(@ModelAttribute("acteur") Acteur acteur,
                               @RequestParam("photoFile") MultipartFile photoFile) {
        // Vérifiez si un nouveau fichier photo a été téléchargé
        if (!photoFile.isEmpty()) {
            try {
                // Générer un identifiant unique pour le nom du fichier
                String uniqueId = UUID.randomUUID().toString();

                // Obtenir l'extension du fichier d'origine
                String originalFilename = photoFile.getOriginalFilename();
                String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));

                // Construire le nouveau nom de fichier avec le nom, prénom, identifiant unique et extension
                String newFileName = acteur.getNom().toLowerCase() + acteur.getPrenom().toLowerCase() + "_" + uniqueId + fileExtension;

                // Lire les bytes du fichier de photo
                byte[] bytes = photoFile.getBytes();

                // Définir le chemin où enregistrer le fichier de photo avec le nouveau nom
                Path path = Paths.get(uploadPath + File.separator + newFileName);

                // Écrire les bytes du fichier dans le chemin spécifié
                Files.write(path, bytes);

                // Associer le nouveau nom de fichier à l'acteur
                acteur.setPhoto(newFileName);

            } catch (IOException e) {
                e.printStackTrace();
                // Gérer l'erreur correctement
            }
        }

        // Enregistrez ou mettez à jour l'acteur dans la base de données
        acteurService.save(acteur);

        // Redirigez l'utilisateur vers une autre page, par exemple la page de détails de l'acteur
        return "redirect:/acteur/getOne/" + acteur.getId();
    }


    @GetMapping("/delete/{id}")
    public String deleteActeur(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        boolean success = acteurService.deleteActeur(id);
        if (success) {
            redirectAttributes.addFlashAttribute("message", "Acteur supprimé avec succès!");
            logger.info("Acteur with id {} deleted successfully.", id);
        } else {
            redirectAttributes.addFlashAttribute("error", "Acteur introuvable!");
            logger.warn("Acteur with id {} not found.", id);
        }
        return "redirect:/acteur/list";
    }

}
