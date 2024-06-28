package org.example;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Entrez la largeur: ");
        double largeur = scan.nextDouble();

        Scanner scanLong = new Scanner(System.in);
        System.out.println("Entrez la longueur: ");
        double longueur = scanLong.nextDouble();



        if ( largeur < 0 || longueur < 0){
            System.out.println("Erreur: vous avez introduit une largeur ou longueur négative.");
        }else{
            calculer(largeur, longueur);
        }


    }

    private static void calculer(double largeur, double longueur) {
        System.out.print("Surface ('s/S') ou perimètre ('p/P')? ");
        char typeCalcul = scan.next().charAt(0);
        switch (typeCalcul ){
            case 's':
            case 'S': {
                double surface = largeur * longueur;
                System.out.println("La surface est " + surface);
                break;
            }
            case 'p':
            case 'P': {
                double perimetre = 2 * (largeur + longueur);
                System.out.println("Le perimetre est est " + perimetre);
                break;
            }
            default: {
                System.out.println ("Introduire un 'p' ou un 's' s.v.p");
            }
        }
    }
}