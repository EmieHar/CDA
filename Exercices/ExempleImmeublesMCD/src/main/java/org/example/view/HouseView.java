package org.example.view;

import org.example.model.entity.Bedroom;
import org.example.model.entity.House;

public class HouseView {

    public void getDetailsHouse(House maison) {
        System.out.println("Détails de la Maison:");

        System.out.println("\n Cuisine:");
        for (String equipement : maison.getKitchen().getEquipments()) {
            System.out.println(" \t- " + equipement);
        }

        System.out.println("\n Salle de Bain:");
        System.out.println(" \t- Superficie: " + maison.getBathroom().getSuperficie());
        System.out.println(" \t- Baignoire: " + (maison.getBathroom().hasBath() ? "Oui" : "Non"));

        System.out.println("Chambres:");
        for (Bedroom chambre : maison.getBedrooms()) {
            System.out.println(" \t- Superficie: " + chambre.getSuperficie());
            System.out.println(" \t- Lit Double: " + (chambre.hasLitDouble() ? "Oui" : "Non"));
        }

        System.out.println("\nBoite aux Lettres:");
        for (String courrier : maison.getMailBox().getMail()) {
            System.out.println(" \t- " + courrier);
        }
    }
}
