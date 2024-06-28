package org.example.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuiz", nullable = false)
    private int id;
    private String titre;
    private String description;
    @Column(name="date_creation")
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions;

    //Contructeurs
    public Quiz(){}

    public Quiz(String titre, String description, Date dateCreation, Niveau niveau, List<Question> questions) {
        this.titre = titre;
        this.description = description;
        this.dateCreation = dateCreation;
        this.niveau = niveau;
        this.questions = questions;
    }

    //Getters et Setters
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


    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public enum Niveau {
        FACILE,
        INTERMEDIAIRE,
        DIFFICILE
    }

}
