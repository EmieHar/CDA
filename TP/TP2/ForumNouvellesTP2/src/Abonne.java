package TP.TP2.ForumNouvellesTP2.src;

import java.util.List;

public class Abonne {

    private String nom;
    private String prenom;
    private int age;
    private int avertissements;
    private IForumAbonne forum;

    public Abonne(String nom, String prenom, int age){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.avertissements = 0;
    }

    // Getters et setters
    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAvertissements() {
        return avertissements;
    }

    public int avertir() {
        this.avertissements++;
        return this.avertissements;
    }

    public void setForum(IForumAbonne forum) {
        this.forum = forum;
    }

    // Méthodes déléguées
    public void ajouterNouvelle(String sujet, String texte) {
        Nouvelle nouvelle = new Nouvelle(sujet, texte);
        forum.ajouterNouvelle(nouvelle);
    }

    public void consulterNouvelle(int index) {
        Nouvelle nouvelle = forum.consulterNouvelle(index); // Consulter doit retourner une Nouvelle
        if (nouvelle != null) {
            System.out.println("Nouvelle: " + nouvelle.getSujet() + " - " + nouvelle.getTexte());
        } else {
            System.out.println("Nouvelle non trouvée.");
        }
    }

    public void repondreNouvelle(int index, String reponseTexte) {
        Nouvelle nouvelle = forum.consulterNouvelle(index);
        if (nouvelle != null) {
            Nouvelle reponse = new Nouvelle(nouvelle.getSujet(), reponseTexte);
            forum.repondreNouvelle(index, reponse);
        } else {
            System.out.println("Nouvelle non trouvée pour répondre.");
        }
    }

    public List<Nouvelle> consulterNouvelles() {
        return forum.listerNouvelles();
    }
}
