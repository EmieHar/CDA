package org.example.view;

import org.example.model.entity.Professeur;
import org.example.model.entity.Specialite;

import java.util.List;
import java.util.Scanner;

public class ProfesseurView {

    private final Scanner scan = new Scanner(System.in);

    public String saisirNom(){
        System.out.println("Nom du nouveau professeur:");
        return scan.nextLine();

    }

    public String saisirPrenom(){
        System.out.println("Son prenom :");
        return scan.nextLine();
    }

    public String saisirTelephone(){
        System.out.println("Son telephone :");
        return scan.nextLine();
    }

    public String saisirEmail(){
        System.out.println("Son email :");
        return scan.nextLine();

    }

    public String saisirSpe(){
        System.out.println("Libellé de sa spécialité :");
        return scan.nextLine();

    }

    public void afficheProfesseurs(List<Professeur> profs){
        System.out.println("\n Liste des Professeurs:");
        if(profs != null){
            for(Professeur prof : profs){
                System.out.println("Nom et Prénom: " + prof.getNom() + " " + prof.getPrenom());
                System.out.println("Telephone: " + prof.getTelephone());
                System.out.println("Email: " + prof.getEmail());

                Specialite specialite = prof.getSpecialite();
                System.out.println("Spécialité: " + (specialite != null ? specialite.getLibelle() : "Non spécifiée") + "\n");

            }
        }else{
            System.out.println("Aucun professeur enregistré");
        }
    }
}
