package org.example.dao;

import org.example.model.Producer;
import org.example.model.Product;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAO {
    //afficher tous le produits
    public List<Product> getProducts(){
        Session session = null;
        Transaction tr = null;
        List<Product> products = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            Query<Product> query = session.createQuery("from Product p left join fetch p.producer", Product.class);

            products = query.getResultList();

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
        return products;
    }


    //afficher les produits de chaque producteurs
    public List<Product> getProducersWithProducts() {
        Session session = null;
        Transaction tr = null;
        List<Product> result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            // Utilisation d'une jointure HQL pour récupérer les produits avec leurs producteurs
            String hql = "from Product p left join fetch p.producer";
            Query<Product> query = session.createQuery(hql, Product.class);
            result = query.getResultList();

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
        return result;
    }


    //afficher les produits d'un producteur
    public List<Product> getProductsByProducer(Producer producer){
        Session session = null;
        Transaction tr = null;
        List<Product> products = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            Query<Product> query = session.createQuery("from Product p where p.producer = :producer", Product.class);
            query.setParameter("producer", producer);

            products = query.getResultList();

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
        return products;
    }



    //afficher un produit
    public Product getProductById(int idProduct){
        Session session = null;
        Transaction tr = null;
        Product product = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            //construction HQL de ma requête
            Query<Product> query = session.createQuery("from Product where idProduct = :id", Product.class);
            query.setParameter("id", idProduct);
            //récupération des résultats sous forme de liste
            product = query.getSingleResult();


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
        return product;
    }
}
