package org.example.projetlexique2.dao;


import org.example.projetlexique2.entity.Choix;
import org.example.projetlexique2.entity.Question;
import org.example.projetlexique2.entity.Quiz;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class QuizDAO {
    private Session session = null;
    private Transaction transaction = null;

    public void ajouterQuestionAuQuiz(Quiz quiz, Question question) {
        int nombreDeQuestions = quiz.getQuestions().size();
        if (nombreDeQuestions >= 15) {
            throw new IllegalArgumentException("Le quiz ne peut pas avoir plus de 15 questions.");
        } else if (nombreDeQuestions < 5) {
            throw new IllegalArgumentException("Le quiz doit avoir au moins 5 questions.");
        }

        quiz.getQuestions().add(question);
    }

    public void ajouterChoixAQuestion(Question question, Choix choix) {
        int nombreChoix = question.getChoix().size();
        if (nombreChoix >= 5) {
            throw new IllegalArgumentException("La question ne peut pas avoir plus de 5 choix.");
        } else if (nombreChoix < 3) {
            throw new IllegalArgumentException("La question doit avoir au moins 3 choix.");
        }

        question.getChoix().add(choix);
    }
}
