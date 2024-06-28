package org.example.filtre_servlet.model.dao;

import org.example.filtre_servlet.model.Cart;
import org.example.filtre_servlet.model.User;
import org.example.filtre_servlet.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAO {
    private Session session;
    private Transaction transaction;

    public User getUser(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = null;

        try {

            String hql = "FROM User WHERE email = :email";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", email);

            user = query.uniqueResult();

        } finally {
            session.close();
        }

        return user;
    }

    public void createCartIfNotExists(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Vérifiez si l'utilisateur a déjà un panier actif
            Cart cart = user.getCart();
            if (cart == null) {
                // Créez un nouveau panier
                cart = new Cart();
                cart.setUser(user);
                user.setCart(cart);
                session.save(cart);
                session.update(user); // Mettez à jour l'utilisateur avec le panier
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
