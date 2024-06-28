package TP.TP2.ForumNouvellesTP2.src;

import java.util.Date;

public class Nouvelle {
    private String sujet;
    private String texte;
    private Date dateCreation;

    // Constructeur
    public Nouvelle(String sujet, String texte) {
        this.sujet = sujet;
        this.texte = texte;
        this.dateCreation = new Date();
    }

    // Getters et setters
    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
