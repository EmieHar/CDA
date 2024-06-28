package org.example.view;

import org.example.model.entity.Mot;

import java.sql.SQLOutput;
import java.util.Scanner;

public class LexiqueView {

    public LexiqueView() {

    }

    public void afficherMot(Mot mot) {

        System.out.println("Mot: " + mot.getMot());
        System.out.println("Définition: " + mot.getDefinition());
        if (mot.getExemple() != null){
            System.out.println("Exemple: " +mot.getExemple());
        }
        if (mot.getImage() != null){
            System.out.println("Image: " + mot.getImage());
        }
    }
    public String saisirMot() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Mot: ");
        return scan.nextLine().trim();
    }

    public String saisirDefinition() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Définition: ");
        return scan.nextLine().trim();
    }

    public String saisirExemple() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Exemple: ");
        String def = scan.nextLine().trim();
        return def.isEmpty() ? null : def;
    }

//    public String saisirExemple() {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Mot: ");
//        String exemple = scan.nextLine();  // Utiliser nextLine() pour lire toute la ligne
//
//        // Vérifier si la chaîne est ni null ni vide
//        if (exemple != null && !exemple.trim().isEmpty()) {
//            return exemple;
//        } else {
//            return null;
//        }
//    }

    public String saisirImage() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Image: ");
        String image = scan.nextLine();

        // Vérifier si la chaîne est ni null ni vide
        if (image != null && !image.trim().isEmpty()) {
            return image;
        } else {
            return null;
        }
    }
    //autre façon de faire:
//    public String saisirImage() {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Image (URL ou chemin): ");
//        String img = scan.nextLine().trim();
//        return img.isEmpty() ? null : img;
//    }

    // Autres méthodes pour interagir avec l'utilisateur
}
