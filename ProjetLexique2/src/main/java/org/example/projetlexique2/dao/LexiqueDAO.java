package org.example.projetlexique2.dao;

import org.example.projetlexique2.entity.Mot;
import org.example.projetlexique2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LexiqueDAO {
    private Session session = null;
    private Transaction transaction = null;

    // afficher les mots et leur définition
    public List<Mot> getMots() {
        List<Mot> mots = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query<Mot> query = session.createQuery("from Mot ", Mot.class);

            mots = query.getResultList();

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return mots;
    }
}
