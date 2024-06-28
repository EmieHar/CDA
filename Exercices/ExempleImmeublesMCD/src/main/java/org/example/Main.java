package org.example;

import org.example.controller.HouseController;
import org.example.model.entity.*;
import org.example.view.HouseView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Kitchen cuisine = new Kitchen(15.0, List.of("Réfrigérateur", "Four", "Lave-vaisselle"));
        Bathroom salleDeBain = new Bathroom(8.0, true);
        List<Bedroom> chambres = List.of(new Bedroom(12.0, true), new Bedroom(10.0, false));
        MailBox boiteAuxLettres = new MailBox();

        House maison = new House(cuisine, chambres, salleDeBain , boiteAuxLettres);
        HouseView maisonView = new HouseView();
        HouseController maisonController = new HouseController(maison, maisonView);

        maisonController.getHouse();

        // Ajouter du courrier comme exemple
        maisonController.addMail("Lettre 1");
        maisonController.addMail("Lettre 2");
    }
}