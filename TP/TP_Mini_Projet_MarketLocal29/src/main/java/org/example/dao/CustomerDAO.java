package org.example.dao;

import org.example.model.BasketItem;
import org.example.model.Customer;
import org.example.model.Basket;
import org.example.model.Product;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDAO {

    //creer son compte
    public void createCustomer(Customer customer){
        Session session = null;
        Transaction tr = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            //lorsque web --> création méthode utilitaire de hashage de password et appel ici

            session.persist(customer);

            tr.commit();
            System.out.println("Client créé, son id est: " + customer.getIdCustomer());

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


    //connection client
    public void customerConnexion(String email, String password) {
        Session session = null;
        Transaction tr = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            Query<Customer> query = session.createQuery("from Customer where email = :email", Customer.class);
            query.setParameter("email", email);
            Customer customer = query.uniqueResult();

            //vérifie que le client existe et que le mot de passe correspond à celui en bdd
            if (customer != null && customer.getPassword().equals(password)) {
                //lorsque sera en web --> hashage password + vérification
                System.out.println("Bienvenue " + customer.getLastName() + " " + customer.getFirstName());

                // Vérifiez s'il y a un panier actif pour ce client
                Basket activeBasket = customer.getBaskets().stream()
                        .filter(b -> b.getOrder() == null) // Panier non associé à une commande
                        .findFirst().orElse(null);

                if (activeBasket == null) {
                    // Créez un nouveau panier si aucun n'est actif
                    activeBasket = new Basket();
                    activeBasket.setCustomer(customer);
                    customer.getBaskets().add(activeBasket);
                    session.save(activeBasket);
                    System.out.println("Panier créé");
                }

                tr.commit();
            } else {
                System.out.println("Erreur de saisie de l'email ou du mot de passe");
                if (tr != null) tr.rollback();
            }

        } catch (Exception ex) {
            if (tr != null) tr.rollback();
            ex.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }


    //Ajouter des produits au panier
    public void addProductToBasket(int customerId, int productId, int quantity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Récupérez le customer à partir de l'ID
            Customer customer = session.get(Customer.class, customerId);

            // Récupérez le produit à partir de l'ID
            Product product = session.get(Product.class, productId);

            //Vérification de la disponibilité du produit
            if (product != null && product.getStock() >= quantity) {
                // Récupérez le panier actif du client
                Basket activeBasket = customer.getBaskets().stream()//Crée un flux (stream) à partir de cette liste de paniers, permettant des opérations de traitement de données.
                        .filter(b -> b.getOrder() == null) //Applique un filtre pour ne conserver que les paniers qui ne sont pas encore associés à une commande
                        .findFirst().orElse(null);//.findFirst() : Trouve le premier panier dans le flux qui correspond au filtre appliqué. S'il y a plusieurs paniers actifs, il en prendra simplement le premier.
                                                        //.orElse(null) : Si aucun panier actif n'est trouvé (le flux est vide), la méthode retourne

                if (activeBasket == null) {
                    // Créez un nouveau panier si aucun n'est actif
                    activeBasket = new Basket();
                    activeBasket.setCustomer(customer);
                    customer.getBaskets().add(activeBasket);
                    session.save(activeBasket);
                }

                // Ajoutez le produit au panier
                BasketItem basketItem = new BasketItem(activeBasket, product, quantity);
                activeBasket.getBasketItems().add(basketItem);
                product.getBasketItems().add(basketItem);

                // Mettez à jour le stock du produit
                product.setStock(product.getStock() - quantity);

                // Enregistrez les modifications dans la base de données
                session.saveOrUpdate(product);
                session.saveOrUpdate(activeBasket);

                tx.commit();
                System.out.println("Le produit " + product.getNameProduct() + " a été ajouté au panier en quantité " + quantity + ".");
                double prix = quantity * product.getPrice();
                System.out.println("prix du panier: " + prix + " Euros" );
            } else {
                System.out.println("Le produit n'est pas disponible en quantité suffisante.");
                if (tx != null) tx.rollback();
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    //afficher les clients en bdd
        public List<Customer> getCustomers(){
            Session session = null;
            Transaction tr = null;
            List<Customer> customers = null;
            try{
                session = HibernateUtil.getSessionFactory().openSession();
                tr = session.beginTransaction();

                //construction HQL de ma requête
                Query<Customer> query = session.createQuery("from Customer", Customer.class);

                //récupération des résultats sous forme de liste
                customers = query.getResultList();


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
            return customers;
        }




}
