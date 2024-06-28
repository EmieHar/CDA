package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;
    private String orderNumber;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    private String status;

    @ManyToOne
    @JoinColumn(name = "idCustomer", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "idProducer", nullable = false)
    private Producer producer;



    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<BasketItem> items;

    // Constructors
    public Order() {
        this.paymentMode = null;
        this.status = "pending";
    }

    public Order(List<BasketItem> items, PaymentMode paymentMode) {
        this.orderNumber = generateOrderNumber();
        this.items = items;
        this.paymentMode = paymentMode;
    }

    // Getters and Setters
    public enum PaymentMode {CB, ESPECE, CHEQUE, PAYPAL;}

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void setItems(List<BasketItem> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    // Méthode pour générer le numéro de commande
    public String generateOrderNumber() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        return getIdOrder() + formattedDateTime;
    }
}
