package org.example.model.dao;

import org.example.HibernateUtil;
import org.example.model.entity.Professeur;
import org.example.model.entity.Specialite;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProfesseurDAO {

    private Session session = null;
    private Transaction tr = null;

    //afficher liste des professeurs
    public List<Professeur> getProfesseurs(){
        List<Professeur> profs = new ArrayList<>();

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            Query<Professeur> query = session.createQuery("from Professeur", Professeur.class);
            profs = query.getResultList();

            tr.commit();

        } catch(Exception e){
            if(tr != null){
                tr.rollback();
            }
            e.getStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return profs;
    }

    //creer un professeur
    public void createProfesseur(Professeur prof, int idSpe){

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            Specialite spe = session.get(Specialite.class, idSpe);
            prof.setSpecialite(spe);
            spe.getProfesseurs().add(prof);

            session.save(prof);

            tr.commit();

        } catch (Exception ex){
            if(tr != null){
                tr.rollback();
            }
            ex.getStackTrace();

        } finally{
            if (session != null) {
                session.close();
            }
        }
    }
}
