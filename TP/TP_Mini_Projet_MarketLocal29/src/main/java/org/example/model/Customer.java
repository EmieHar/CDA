package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Basket> baskets;

    //Constructors
    public Customer(){}

    public Customer(String lastName, String firstName, String phoneNumber, String email, String address, String password) {
        super(lastName, firstName, phoneNumber, email, address,password);
    }

    //getter and setter
    public int getIdCustomer(){
        return idCustomer;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }
}
