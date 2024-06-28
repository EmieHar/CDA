package TP.TP2.ForumNouvellesTP2.src;

import java.util.List;

public class Moderateur {

    private String nom;
    private String prenom;
    private int age;
    private IForumModerateur forum;

    public Moderateur(String nom, String prenom, int age){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    //Getters
    public String getNom(){
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setForum(IForumModerateur forum) {
        this.forum = forum;
    }

    // Méthodes déléguées
    public int ajouterAbonne(Abonne abonne) {
        return forum.ajouterAbonne(abonne);
    }

    public void exclureAbonne(Abonne abonne) {
        forum.bannirAbonne(abonne);
    }

    public void supprimerNouvelle(Nouvelle nouvelle) {
        forum.supprimerNouvelle(nouvelle);
    }


    // Méthode pour avertir un abonné
    public void avertirAbonne(Abonne abonne) {
        int avertissement = abonne.avertir();
        System.out.println("\n" +abonne.getNom() + " " + abonne.getPrenom() + " 1 avertissement reçu, ce qui vous fait: " + avertissement + "reçu(s). Au 3e c'est le bannissement");
        if (abonne.getAvertissements() >= 3) {
            forum.bannirAbonne(abonne);
            System.out.println(abonne.getNom() + " " + abonne.getPrenom() + " tu viens de recevoir ton 3e avertissement. Au revoir !");
        }
    }

    public List<Nouvelle> listerNouvelles() {
        return forum.listerNouvelles();
    }

    public List<Abonne> listerAbonnes() {
        return forum.listerAbonnes();
    }
}
