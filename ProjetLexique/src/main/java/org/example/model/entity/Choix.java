package org.example.model.entity;

import org.example.model.entity.Question;

import javax.persistence.*;

@Entity
@Table(name="choix")
public class Choix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idChoix")
    private Long id;
    private String label;
    private boolean is_correct;

    @ManyToOne
    @JoinColumn(name = "Id_Question")
    private Question question;


    public Choix() {}

    public Choix(String label, boolean is_correct, Question question) {
        this.label = label;
        this.is_correct = is_correct;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
}
