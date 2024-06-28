package TP.TP2.ForumNouvellesTP2.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Forum implements IForumAbonne, IForumModerateur {
    private Date dateCreation;
    private String nom;
    private ArrayList<Nouvelle> nouvelles;
    private ArrayList<Abonne> abonnes;

    // Constructeur
    public Forum(String nom) {
        this.nom = nom;
        this.dateCreation = new Date();
        this.nouvelles = new ArrayList<>();
        this.abonnes = new ArrayList<>();
    }

    // Getters et setters
    public Date getDateCreation() {
        return dateCreation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Nouvelle> getNouvelles() {
        return nouvelles;
    }

    public ArrayList<Abonne> getAbonnes() {
        return abonnes;
    }

    // Implémentation des méthodes de IForumAbonne

    public boolean ajouterNouvelle(Nouvelle nouvelle) {
        return nouvelles.add(nouvelle);
    }

    public Nouvelle consulterNouvelle(int index) {
        if (index >= 0 && index < nouvelles.size()) {
            return nouvelles.get(index);
        }
        return null;
    }

    public void repondreNouvelle(int index, Nouvelle reponse) {
        if (index >= 0 && index < nouvelles.size()) {
            nouvelles.add(reponse);
        }
    }

    public List<Nouvelle> listerNouvelles() {
        return nouvelles;
    }

    // Implémentation des méthodes de IForumModerateur

    public boolean supprimerNouvelle(Nouvelle nouvelle) {
        return nouvelles.remove(nouvelle);
    }

    public void bannirAbonne(Abonne abonne) {
        abonnes.remove(abonne);
    }

    public int ajouterAbonne(Abonne abonne) {
        abonnes.add(abonne);
        return abonnes.size();
    }

    public void afficherAbonnes() {
        for (Abonne abonne : abonnes) {
            System.out.println("Abonné: " + abonne.getPrenom() + " " + abonne.getNom() + ", Age: " + abonne.getAge() + ", Avertissements: " + abonne.getAvertissements());
        }
    }

    public List<Abonne> listerAbonnes() {
        return abonnes;
    }
}

