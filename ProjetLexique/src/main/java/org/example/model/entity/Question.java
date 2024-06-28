package org.example.model.entity;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Question", nullable = false)
    private int idQuestion;
    @Column(name="question")
    private String label;
    private boolean is_correct;

    @ManyToOne
    @JoinColumn(name = "idQuiz")
    private Quiz quiz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Choix> choix;

    //Constructeurs
    public Question(){  }

    public Question(String label, Quiz quiz, boolean is_correct, List<Choix> choix) {
        this.label = label;
        this.quiz = quiz;
        this.is_correct = is_correct;
        this.choix = choix;
    }

    //Getters et Setters
    public int getId() {
        return idQuestion;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isIs_correct() {
        return is_correct;
    }

    public void setIs_correct(boolean is_correct) {
        this.is_correct = is_correct;
    }


    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Choix> getChoix() {
        return choix;
    }

    public void setChoix(List<Choix> choix) {
        this.choix = choix;
    }
}

