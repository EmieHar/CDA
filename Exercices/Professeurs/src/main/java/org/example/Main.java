package org.example;

import org.example.controller.ProfesseurController;
import org.example.controller.SpecialiteController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SpecialiteController spe = new SpecialiteController();
        //spe.createSpecialite();
        spe.afficheSpecialites();
        spe.afficheProfesseurParSpe();

        ProfesseurController pc = new ProfesseurController();
        pc.createProfesseur();
        pc.afficheProfesseurs();

    }
}