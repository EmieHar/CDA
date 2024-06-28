package org.example.model.dao;

import org.example.HibernateUtil;
import org.example.model.entity.Specialite;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class SpecialiteDAO {
    private Session session = null;
    private Transaction tr = null;

    //afficher liste des spécialités
    public List<Specialite> getSpecialites(){
        List<Specialite> spes = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            Query<Specialite> query = session.createQuery("from Specialite", Specialite.class);
            spes = query.getResultList();

            tr.commit();

        }  catch( Exception ex ) {

            if( tr != null ){
                tr.rollback();
            }
            ex.getStackTrace();

        } finally {

            if (session != null) {
                session.close();
            }
        }
        return spes;
    }

    //obtenir l'id d'une spécialité par son nom
    public int getIdSpeByName(String nomSpe){
         int idSpe = 0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            Query<Specialite> query = session.createQuery("from Specialite where libelle = :libelle", Specialite.class);
            query.setParameter("libelle", nomSpe);
            Specialite spe = query.getSingleResult();
            idSpe = spe.getId();

            tr.commit();

        }  catch( Exception ex ) {

            if( tr != null ){
                tr.rollback();
            }
            ex.getStackTrace();

        } finally {

            if (session != null) {
                session.close();
            }
        }
        return idSpe;
    }


    //créer spécialité
    public void createSpecialite(String code, String libelle){

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr =session.beginTransaction();
            Specialite spe = new Specialite(code, libelle);
            session.persist(spe);
            tr.commit();
            System.out.println("nouvelle spécialité créée, son id: " + spe.getId());

        } catch( Exception ex ) {

            if( tr != null ){
                tr.rollback();
            }
            ex.getStackTrace();

        } finally {

            if(session!= null){
                session.close();
            }
        }

    }

    //afficher la liste des professeurs par spécialité
    public List<Specialite> getProfesseurBySpecialite() {

        List<Specialite> specialites = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tr = session.beginTransaction();

            //select distinct pour n'avoir chaque spécialité qu'une seule fois
            Query<Specialite> query = session.createQuery("select distinct s from Specialite s left join fetch s.professeurs", Specialite.class);
            specialites = query.getResultList();

            tr.commit();

        } catch (Exception e) {

            if (tr != null) {
                tr.rollback();
            }
            e.getStackTrace();

        } finally {

            if(session!= null){
                session.close();
            }

        }

        return specialites;

    }
}
