package org.example.controller;

import org.example.model.entity.Professeur;
import org.example.model.service.ProfesseurService;
import org.example.model.service.SpecialiteService;
import org.example.view.ProfesseurView;

import java.util.List;

public class ProfesseurController {

    private final ProfesseurService professeurService;
    private final ProfesseurView viewProfesseur;

    public ProfesseurController(){
        this.professeurService = new ProfesseurService();
        this.viewProfesseur = new ProfesseurView();
    }

    public void createProfesseur(){

        String nom = viewProfesseur.saisirNom();
        String prenom = viewProfesseur.saisirPrenom();
        String telephone = viewProfesseur.saisirTelephone();
        String email = viewProfesseur.saisirEmail();
        String spe = viewProfesseur.saisirSpe();

        SpecialiteService specialiteService = new SpecialiteService();
        int id = specialiteService.getIdSpeByName(spe);

        Professeur  prof = new Professeur(nom, prenom, telephone,email);

        // utilisation méthode toString()
        System.out.println(prof.toString());
            // Ou simplement
        //System.out.println(prof);

        professeurService.createProfesseur(prof,id);
        System.out.println("Professeur " + nom + " " + prenom + " créé");
    }

    public void afficheProfesseurs(){
        List<Professeur> profs= professeurService.getProfesseurs();
        viewProfesseur.afficheProfesseurs(profs);
    }


}
