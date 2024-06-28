package org.example.dao;

import org.example.model.Producer;
import org.example.model.Product;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProducerDAO {

    //creer son compte
    public void createProducer(Producer producer){
        Session session = null;
        Transaction tr = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            session.persist(producer);

            tr.commit();
            System.out.println("Producteur créé, son id est: " + producer.getIdProducer());

        } catch( Exception ex ) {

            if( tr != null ){
                tr.rollback();
            }
            ex.printStackTrace();

        } finally {

            if(session!= null){
                session.close();
            }
        }
    }

    //afficher les producteurs en bdd
    public List<Producer> getProducers(){
        Session session = null;
        Transaction tr = null;
        List<Producer> producers = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            //construction HQL de ma requête
            Query<Producer> query = session.createQuery("from Producer", Producer.class);

            //récupération des résultats sous forme de liste
            producers = query.getResultList();


        } catch( Exception ex ) {

            if( tr != null ){
                tr.rollback();
            }
            ex.printStackTrace();

        } finally {

            if(session!= null){
                session.close();
            }
        }
        return producers;
    }

    //afficher un producteur
    public Producer getProducerById(int idProducer){
        Session session = null;
        Transaction tr = null;
        Producer producer = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            //construction HQL de ma requête
            Query<Producer> query = session.createQuery("from Producer where idProducer = :id", Producer.class);
            query.setParameter("id", idProducer);
            //récupération des résultats sous forme de liste
            producer = query.getSingleResult();


        } catch( Exception ex ) {

            if( tr != null ){
                tr.rollback();
            }
            ex.printStackTrace();

        } finally {

            if(session!= null){
                session.close();
            }
        }
        return producer;
    }

    //supprimer un producteur
    public void deleteProducer(int idProducer){
        Session session = null;
        Transaction tr = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            // Récupération de l'entité Producer par son id
            Producer producer = session.get(Producer.class, idProducer);

            if (producer != null) {
                session.remove(producer);
            }

            tr.commit();

        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    //creer un produit
    public void createProduct(Product product, Producer producer){
        Session session = null;
        Transaction tr = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            product.setProducer(producer);

            session.persist(product);

            tr.commit();
            System.out.println("Produit créé, son id est: " + product.getIdProduct());

        } catch( Exception ex ) {

            if( tr != null ){
                tr.rollback();
            }
            ex.printStackTrace();

        } finally {

            if(session!= null){
                session.close();
            }
        }
    }

    //modifier un produit
    public void updateProduct(Product updatedProduct, Product productSelected) {
        Session session = null;
        Transaction tr = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            // Récupération de l'entité Product par son id
            Product product = session.get(Product.class, productSelected.getIdProduct());

            if (product != null) {
                // Affichage des changements effectués
                System.out.println("Changements apportés au produit : " + productSelected.getIdProduct());
                if (!product.getNameProduct().equals(updatedProduct.getNameProduct())) {
                    System.out.println("Nom du produit : " + updatedProduct.getNameProduct());
                    product.setNameProduct(updatedProduct.getNameProduct());
                }
                if (!product.getDescription().equals(updatedProduct.getDescription())) {
                    System.out.println("Description : " + updatedProduct.getDescription());
                    product.setDescription(updatedProduct.getDescription());
                }
                if (product.getPrice() != updatedProduct.getPrice()) {
                    System.out.println("Prix : " + updatedProduct.getPrice());
                    product.setPrice(updatedProduct.getPrice());
                }
                if (product.getStock() != updatedProduct.getStock()) {
                    System.out.println("Stock : " + updatedProduct.getStock());
                    product.setStock(updatedProduct.getStock());
                }

                // session.update(product); --> redondant car session.get() persiste les données
                // donc Hibernate détecte les changements et synchronise la BDD lors du tr.commit()
            }

            tr.commit();

        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    //suppr un produit
    public void deleteProduct(int idProduct){
        Session session = null;
        Transaction tr = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            // Récupération de l'entité Producer par son id
            Product product = session.get(Product.class, idProduct);

            if (product != null) {
                session.remove(product);
            }

            tr.commit();

        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
