package org.example.filtre_servlet.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String email;
    private String password;
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCart", referencedColumnName = "idCart")
    //mappedBy : indique que propriétaire de la relation = User + que jointure définie dans classe User avec attribut cart.
    //referencedColumnName : Spécifie colonne dans la table Cart qui est liée à colonne idCart dans table User.
    private Cart cart;

    //constructors
    public User() {}

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }


    //getters and setters
    public int getIdUser() {
        return idUser;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
        if (cart != null) {
            cart.setUser(this);
        }
    }



}


