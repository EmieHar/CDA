package org.example.dao;

import org.example.model.*;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderDAO {

    public void createOrder(int customerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Customer customer = session.get(Customer.class, customerId);
            Basket activeBasket = findActiveBasket(customer);
            validateBasket(activeBasket);

            // Grouper les articles du panier par producteur
            Map<Producer, List<BasketItem>> itemsByProducer = activeBasket.getBasketItems().stream()
                    .collect(Collectors.groupingBy(item -> item.getProduct().getProducer()));

            // Créer une commande pour chaque producteur
            for (Map.Entry<Producer, List<BasketItem>> entry : itemsByProducer.entrySet()) {
                Producer producer = entry.getKey();
                List<BasketItem> items = entry.getValue();

                Order order = new Order();
                order.setCustomer(customer);
                order.setProducer(producer);
                order.setItems(items);
                order.setBasket(activeBasket);

                // Associez chaque article de panier à cette commande
                for (BasketItem item : items) {
                    item.setOrder(order);
                }

                updateProductStock(items, session);

                session.save(order);
                System.out.println("Commande créée avec succès. Numéro de commande: " + order.getOrderNumber());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void payOrder(int orderId, Order.PaymentMode paymentMode) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Order order = session.get(Order.class, orderId);
            if (order == null) {
                throw new RuntimeException("Pas de commande trouvé avec l'id: " + orderId);
            }

            order.setPaymentMode(paymentMode);
            order.setStatus("payée");

            session.update(order);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateOrderStatus(int orderId, String status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Order order = session.get(Order.class, orderId);
            if (order == null) {
                throw new RuntimeException("Pas de commande trouvé avec l'id: " + orderId);
            }
            order.setStatus(status);

            session.update(order);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    private Basket findActiveBasket(Customer customer) {
        return customer.getBaskets().stream()
                .filter(b -> b.getOrder() == null)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucun panier actif trouvé"));
    }

    private void validateBasket(Basket basket) {
        if (basket == null || basket.getBasketItems().isEmpty()) {
            throw new RuntimeException("Panier actif vide ou non trouvé pour le client.");
        }
    }

    private void updateProductStock(List<BasketItem> items, Session session) {
        for (BasketItem item : items) {
            Product product = item.getProduct();
            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Stock insuffisant pour le produit : " + product.getNameProduct());
            }
            product.setStock(product.getStock() - item.getQuantity());
            session.update(product);
        }
    }
}
