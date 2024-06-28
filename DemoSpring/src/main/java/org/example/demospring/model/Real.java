package org.example.demospring.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="director")

public class Real {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_director")
    private int id;
    private String nom;
    private String prenom;
    private String photo;

    @OneToMany(mappedBy = "real", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Film> films;

    public Real(){}

    public Real(String nom, String prenom, String photo) {
        this.nom = nom;
        this.prenom =prenom;
        this.photo=photo;
    }

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

        public Set<Film> getFilms() {
            return films;
        }

        public void setFilms(Set<Film> films) {
            this.films = films;
        }

        public String getPhoto() {return photo;}

        public void setPhoto(String photo) {this.photo=photo;}

    }


