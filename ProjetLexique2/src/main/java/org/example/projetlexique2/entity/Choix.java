package org.example.projetlexique2.entity;

import javax.persistence.*;

@Entity
@Table(name="choix")
public class Choix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idChoix")
    private int id;

    private String label;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Choix() {}

    public Choix(String label, boolean isCorrect, Question question) {
        this.label = label;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
