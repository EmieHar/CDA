package org.example.model.dao;

import org.example.HibernateUtil;
import org.example.model.entity.Mot;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MotDAO {

    private Session session = null;
    private Transaction transaction = null;

    public void ajouterMot(Mot mot) {

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            session.persist(mot);// passe de l'état transitoire à l'état persist ce qu'il y a dans la session
            //session.flush(); si pas de tr.commit() --> dit d'écrire dans la bdd ce qu'il y a dans la session
            transaction.commit();
            System.out.println("Mot ajouter en Bdd avec l'id: " + mot.getId());

        } catch( Exception ex ) {

            if( transaction != null ){
                transaction.rollback();
            }
            ex.getMessage();

        } finally {

            if(session!= null){
                session.close();
            }
        }
    }

//    public Mot obtenirMot(int id) {
//        // Code pour obtenir un mot depuis la base de données
//    }


//    public List<Ecrivain> getEcrivains() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Query<Ecrivain> query = session.createQuery("from Ecrivain", Ecrivain.class);
//        List<Ecrivain> ecrivains = query.getResultList();
//        return ecrivains;
//    }
//
//
//
////    public Ecrivain getEcrivainByName(String nom) {
////        Session session = HibernateUtil.getSessionFactory().openSession();
////        Query<Ecrivain> query = session.createNamedQuery("by_nom", Ecrivain.class);
////        query.setParameter("nom", nom);
////        Ecrivain ecrivain = query.getSingleResult();
////        return ecrivain;
////    }
//
//    public List<Ecrivain> getEcrivainByName(String nom) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Query<Ecrivain> query = session.createNamedQuery("by_nom", Ecrivain.class);
//        query.setParameter("nom", nom);
//        List<Ecrivain> ecrivain = query.getResultList();
//        return ecrivain;
//    }


    // Autres méthodes CRUD
}
