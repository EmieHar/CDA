package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "basket_items")
public class BasketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBasketItem;

    @ManyToOne
    @JoinColumn(name = "idBasket", nullable = false)
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "idProduct", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "idOrder")
    private Order order;

    private int quantity;

    // Constructors, getters, and setters
    public BasketItem() {}

    public BasketItem(Basket basket, Product product, int quantity) {
        this.basket = basket;
        this.product = product;
        this.quantity = quantity;
    }

    // getters and setters
    public int getIdBasketItem() {
        return idBasketItem;
    }

    public void setIdBasketItem(int idBasketItem) {
        this.idBasketItem = idBasketItem;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
