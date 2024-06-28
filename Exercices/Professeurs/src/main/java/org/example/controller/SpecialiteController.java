package org.example.controller;

import org.example.model.entity.Specialite;
import org.example.model.service.SpecialiteService;
import org.example.view.SpecialiteView;

import java.util.List;

public class SpecialiteController {

    private final SpecialiteService specialiteService;
    private final SpecialiteView viewSpecilite;

    public SpecialiteController(){
        this.specialiteService = new SpecialiteService();
        this.viewSpecilite = new SpecialiteView();
    }

    public void createSpecialite(){
        String code = viewSpecilite.saisirCode();
        String libelle = viewSpecilite.saisirLibelle();
        specialiteService.createSpecilite(code,libelle);
        System.out.println("Spécialité " + libelle + " créée");
    }

    public void afficheSpecialites(){
        List<Specialite> spes = specialiteService.getSpecialites();
        viewSpecilite.afficheSpe(spes);

    }

    public void afficheProfesseurParSpe(){
        List<Specialite> spes = specialiteService.getProfesseurBySpecialite();
        viewSpecilite.afficheProfsBySpes(spes);
    }
}
