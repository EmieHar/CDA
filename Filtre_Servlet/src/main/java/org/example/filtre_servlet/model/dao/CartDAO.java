package org.example.filtre_servlet.model.dao;

import org.example.filtre_servlet.model.Cart;
import org.example.filtre_servlet.model.Product;
import org.example.filtre_servlet.model.User;
import org.example.filtre_servlet.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CartDAO {

    // Ajouter des produits au panier
    public void addProductToBasket(int userId, int productId, int quantity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Récupérez l'utilisateur à partir de l'ID
            User customer = session.get(User.class, userId);

            // Récupérez le produit à partir de l'ID
            Product product = session.get(Product.class, productId);

            // Vérification de la disponibilité du produit
            if (product != null && product.getStock() >= quantity) {
                // Récupérez le panier actif du client
                Cart activeCart = customer.getCart();

                if (activeCart == null) {
                    // Créez un nouveau panier si aucun n'est actif
                    activeCart = new Cart();
                    activeCart.setUser(customer);
                    customer.setCart(activeCart);
                    session.save(activeCart);
                }

                // Ajoutez le produit au panier
                double totalPriceForThisAddition = quantity * product.getPrix();
                activeCart.setQuantity(activeCart.getQuantity() + quantity);
                activeCart.setTotalPrice((float) (activeCart.getTotalPrice() + totalPriceForThisAddition));
                activeCart.getProducts().add(product);

                // Mettez à jour le stock du produit
                product.setStock(product.getStock() - quantity);

                // Enregistrez les modifications dans la base de données
                session.saveOrUpdate(product);
                session.saveOrUpdate(activeCart);

                tx.commit();
                System.out.println("Le produit " + product.getNom_produit() + " a été ajouté au panier en quantité " + quantity + ".");
                System.out.println("Prix du panier: " + activeCart.getTotalPrice() + " Euros");
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


}
