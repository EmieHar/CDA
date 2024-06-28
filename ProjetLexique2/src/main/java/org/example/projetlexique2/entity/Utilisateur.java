package org.example.projetlexique2.entity;

import javax.persistence.*;

@Entity
@Table(name="utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_Utilisateur")
    private int id;
    @Column(name="nom_utilisateur")
    private String nomUtilisateur;
    @Column(name="mot_de_passe")
    private String motDePasse;
    private String email;

    //Constructeurs
    public Utilisateur(){}

    public Utilisateur(String nomUtilisateur, String motDePasse, String email) {
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.email = email;
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

