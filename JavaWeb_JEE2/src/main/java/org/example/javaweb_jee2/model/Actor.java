package org.example.javaweb_jee2.model;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(query= "from Actor where nom =: nom", name="by_nom" )
@Table(name="acteur")

public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String prenom;
    private String nom;
    private String photo;

    @ManyToMany(mappedBy = "acteurs")
    private List<Film> films;

    public Actor() {
    }

    public Actor(String name, String firstname, String photo) {
        this.nom = name;
        this.prenom = firstname;
        this.photo = photo;
    }

    public Actor(String name, String firstname, String photo, int id) {
        this.nom = name;
        this.prenom = firstname;
        this.photo = photo;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String firstname) {
        this.prenom = firstname;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String name) {
        this.nom = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
