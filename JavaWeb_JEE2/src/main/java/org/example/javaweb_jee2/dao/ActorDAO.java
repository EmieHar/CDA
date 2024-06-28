package org.example.javaweb_jee2.dao;

import org.example.javaweb_jee2.model.Actor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class ActorDAO {
    public List<Actor> getActors() {
        Transaction transaction = null;
        List<Actor> actors = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "FROM Actor";
            actors = session.createQuery(hql, Actor.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return actors;
    }

    public Actor getActorById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (session.get(Actor.class,id));
    }

    public boolean createActor(Actor actor) {
        Transaction transaction = null;
        Session session = null;
        boolean result = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            // Commencer une transaction
            transaction = session.beginTransaction();

            // Sauvegarder l'objet acteur
            session.save(actor);

            // Commettre la transaction
            transaction.commit();

            System.out.println("Actor added successfully!");
            result = true;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Failed to add actor");
        }finally {
            session.close();
        }
        return result;
    }

    public void updateActor(int id, Actor actor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Commencer une transaction
            transaction = session.beginTransaction();

            // Récupérer l'acteur existant par son ID
            Actor existingActor = session.get(Actor.class, id);
            if (existingActor != null) {
                // Mettre à jour les champs de l'acteur existant
                existingActor.setNom(actor.getNom());
                existingActor.setPrenom(actor.getPrenom());
                existingActor.setPhoto(actor.getPhoto());

                // Sauvegarder les modifications
                session.update(existingActor);
                System.out.println("Actor updated successfully!");
            } else {
                System.out.println("Actor with ID " + actor.getId() + " not found.");
            }

            // Commettre la transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Failed to update actor");
        }
    }
}
