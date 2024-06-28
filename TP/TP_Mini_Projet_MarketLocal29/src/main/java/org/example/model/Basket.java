package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="panier")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBasket;

    @ManyToOne
    @JoinColumn(name = "idCustomer", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private List<BasketItem> basketItems;

    @OneToOne(mappedBy = "basket")
    private Order order;

    // Constructors
    public Basket() {}

    public Basket(Customer customer) {
        this.customer = customer;
    }

    // Getters and Setters
    public int getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(int idBasket) {
        this.idBasket = idBasket;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
