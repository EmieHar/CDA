package org.example.demospring.model;
import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
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

    @Transient
    private MultipartFile afficheFile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genre", nullable = false)
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_director", nullable = false)
    private Real real;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name="joue",
            joinColumns = {@JoinColumn(name="idfilm")},
            inverseJoinColumns = {@JoinColumn(name="idacteur")}
    )
    private Set<Acteur> acteurs = new HashSet<>();


    public Film() {
    }

    public Film(String titre, String description, String affiche, Genre genre, Real real) {
        this.titre = titre;
        this.description = description;
        this.affiche = affiche;
        this.genre = genre;
        this.real = real;
    }

    public Film(int id, String titre, String description, String affiche, Genre genre, Real real, Set<Acteur>acteurs) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.affiche = affiche;
        this.genre = genre;
        this.real = real;
        this.acteurs = acteurs;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {this.id=id;}

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

    public Set<Acteur> getActeurs() {
        return acteurs;
    }
    public void setActeurs(Set<Acteur> acteurs) {
            this.acteurs = acteurs;
        }

    public MultipartFile getAfficheFile() {
        return afficheFile;
    }

    public void setAfficheFile(MultipartFile afficheFile) {
        this.afficheFile = afficheFile;
    }
}

