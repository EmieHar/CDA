package org.example.model.entity;


import javax.persistence.*;

@Entity

public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;

    @ManyToOne
    @JoinColumn(name= "idSpecialite", nullable = false)
    private Specialite specialite;

    //Constructeurs
    public Professeur(){}

    public Professeur(String nom, String prenom, String telephone, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
    }

    public Professeur(String nom, String prenom, String telephone, String email, Specialite specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.specialite = specialite;
    }

    //Accesseurs
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Specialite getSpecialite() {
        return specialite;
    }
    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    //méthode toString() utilisée pour fournir représentation textuelle d'un objet
    //--> souvent redéfinie dans les classes pour donner une description lisible et informative des objets,
    public String toString() {
        return "Professeur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", specialite=" + specialite +
                '}';
    }
}
