package org.example.model.entity;

public class Utilisateur {

    private int id;
    private String nomUtilisateur;
    private String motDePasse;
    private String email;

    //Constructeurs
    public Utilisateur(){}

    public Utilisateur(int id) {
        this.id = id;
    }

    //Getters et Setters
    public int getId() {
        return id;
    }


    public String getNomUtilisateur() {
        return nomUtilisateur;
    }
    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }


    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}

