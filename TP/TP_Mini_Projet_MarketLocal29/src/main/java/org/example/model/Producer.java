package org.example.model;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name="producers")
public class Producer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducer;
    private String professionalAddress;
    private long siretNumber;

    @OneToMany(mappedBy="producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @OneToMany(mappedBy="producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    //Constructors
    public Producer(){}

    public Producer(String lastName, String firstName, String phoneNumber, String email, String address, String password, String professionalAddress, long siretNumber) {
       super(lastName, firstName, phoneNumber, email, address, password);
       this.professionalAddress = professionalAddress;
       this.siretNumber = siretNumber;
    }

    //getter and setter
    public int getIdProducer() {
        return idProducer;
    }

    public String getProfessionalAddress() {
        return professionalAddress;
    }

    public void setProfessionalAddress(String professionalAddress) {
        this.professionalAddress = professionalAddress;
    }

    public long getSiretNumber() {
        return siretNumber;
    }

    public void setSiretNumber(long siretNumber) {
        this.siretNumber = siretNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
