package org.example.controller;

import org.example.model.service.MotService;
import org.example.model.entity.Mot;
import org.example.view.LexiqueView;

public class MotController {

    private MotService motService = new MotService();
    private LexiqueView viewLexique = new LexiqueView();

    public void ajouterMot() {
        String mot = viewLexique.saisirMot();
        String definition = viewLexique.saisirDefinition();
        String exemple = viewLexique.saisirExemple();
        String image = viewLexique.saisirImage();

        if (exemple == null) {
            System.out.println("Exemple non fourni.");
        }

        if (image == null) {
            System.out.println("Image non fournie.");
        }

        Mot nouveauMot = new Mot(mot, definition, exemple, image);
        motService.ajouterMot(nouveauMot);
        viewLexique.afficherMot(nouveauMot);
    }
}
