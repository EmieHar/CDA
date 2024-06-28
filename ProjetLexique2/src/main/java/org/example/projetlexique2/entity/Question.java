package org.example.projetlexique2.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_Question", nullable = false)
    private int idQuestion;

    @Column(name="question")
    private String label;

    @ManyToOne
    @JoinColumn(name = "IdQuiz")
    private Quiz quiz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Choix> choix;

    public Question() {}

    public Question(String label, Quiz quiz, List<Choix> choix) {
        this.label = label;
        this.quiz = quiz;
        this.choix = choix;
    }

    // Getters and setters

    public int getId() {
        return idQuestion;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
