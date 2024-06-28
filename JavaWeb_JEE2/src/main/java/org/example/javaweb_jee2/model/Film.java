package org.example.javaweb_jee2.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="film")

public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String titre;
    private String description;
    private String affiche;

    @ManyToOne
    @JoinColumn(name = "id_genre", nullable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "id_director", nullable = false)
    private Real real;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name="joue",
            joinColumns = {@JoinColumn(name="idFilm")},
            inverseJoinColumns = {@JoinColumn(name="idActeur")}
    )
    private List<Actor> acteurs;


    public Film() {
    }

    public Film(String titre, String description, String affiche, Genre genre, Real real) {
        this.titre = titre;
        this.description = description;
        this.affiche = affiche;
        this.genre = genre;
        this.real = real;
    }


    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    public Real getReal() {
        return real;
    }

    public void setReal(Real real) {
        this.real = real;
    }

    public List<Actor> getActors() {
        return acteurs;
    }
    public void setActors(List<Actor> acteurs) {
        this.acteurs = acteurs;
    }

}

