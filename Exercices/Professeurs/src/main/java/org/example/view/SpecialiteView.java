package org.example.view;

import org.example.model.entity.Professeur;
import org.example.model.entity.Specialite;

import java.util.List;
import java.util.Scanner;

public class SpecialiteView {

    public void afficheSpe(List<Specialite> specialites){
        System.out.println("Liste des spécialités:");

        if (specialites != null){
            for(Specialite specialite : specialites){
                System.out.println(". " + specialite.getLibelle() + " (code: " + specialite.getCode() +")");
            }
        } else {
            System.out.println("Specialite non trouvée.");
        }

    }

    public String saisirCode(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Code de la nouvelle spécialité:");
        return scan.next();
    }

    public String saisirLibelle(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Libellé de la nouvelle spécialité:");
        return scan.next();
    }

    public void afficheProfsBySpes(List<Specialite> spes) {
        System.out.println("Liste des professeurs par spécalités");
        if (spes != null && !spes.isEmpty()) {
            for (Specialite spe : spes) {
                System.out.println("\n .Spécialité: " + spe.getLibelle());

                List<Professeur> profs = spe.getProfesseurs();

                if (profs != null && !profs.isEmpty()) {
                    for (Professeur prof : profs) {
                        System.out.println("\t - Nom et Prénom: " + prof.getNom() + " " + prof.getPrenom() + " Email: " + prof.getEmail());
                    }

                } else {
                    System.out.println("\tAucun professeur dans cette spécialité.");
                }

            }
        } else {
            System.out.println("Aucune spécialité enregistrée.");
        }

    }



}
