package org.example.filtre_servlet.model.dao;

import org.example.filtre_servlet.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.example.filtre_servlet.utils.HibernateUtil;

import java.util.List;

public class ProduitDAO {

    //afficher tous le produits
    public List<Product> getProducts(){
        Session session = null;
        Transaction tr = null;
        List<Product> products = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            Query<Product> query = session.createQuery("from Product ", Product.class);

            products = query.getResultList();

            tr.commit();

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



    //creer un produit
    public boolean createProduct(Product product){
        Session session = null;
        Transaction tr = null;
        boolean success = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();


            session.persist(product);

            tr.commit();
            System.out.println("Produit créé, son id est: " + product.getIdProduct());
            success = true;

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
        return success;
    }



    //modifier un produit
    public boolean updateProduct(Product updatedProduct, Product productSelected) {
        Session session = null;
        Transaction tr = null;
        boolean success = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            // Récupération de l'entité Product par son id
            Product product = session.get(Product.class, productSelected.getIdProduct());

            if (product != null) {

                // Affichage des changements effectués
                System.out.println("Changements apportés au produit : " + productSelected.getIdProduct());
                if (!product.getNom_produit().equals(updatedProduct.getNom_produit())) {
                    System.out.println("Nom du produit : " + updatedProduct.getNom_produit());
                    product.setNom_produit(updatedProduct.getNom_produit());
                }
                if (!product.getDescription().equals(updatedProduct.getDescription())) {
                    System.out.println("Description : " + updatedProduct.getDescription());
                    product.setDescription(updatedProduct.getDescription());
                }
                if (product.getPrix() != updatedProduct.getPrix()) {
                    System.out.println("Prix : " + updatedProduct.getPrix());
                    product.setPrix(updatedProduct.getPrix());
                }
                if (!product.getDescription().equals(updatedProduct.getDescription())) {
                    System.out.println("Stock : " + updatedProduct.getDescription());
                    product.setDescription(updatedProduct.getDescription());
                }
                if (!product.getPhoto().equals(updatedProduct.getPhoto())) {
                    System.out.println("Stock : " + updatedProduct.getPhoto());
                    product.setPhoto(updatedProduct.getPhoto());
                }
                if (product.getStock() != updatedProduct.getStock()) {
                    System.out.println("Stock : " + updatedProduct.getStock());
                    product.setStock(updatedProduct.getStock());
                }

                // session.update(product); --> redondant car session.get() persiste les données
                // donc Hibernate détecte les changements et synchronise la BDD lors du tr.commit()
            }

            tr.commit();
            success = true;

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
        return success;
    }


    //suppr un produit
    public boolean deleteProduct(int idProduct){
        Session session = null;
        Transaction tr = null;
        boolean succes= false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            // Récupération de l'entité Producer par son id
            Product product = session.get(Product.class, idProduct);

            if (product != null) {
                session.remove(product);
            }

            tr.commit();
            succes = true;
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
        return succes;
    }
}
