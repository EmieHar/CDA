package org.example.filtre_servlet.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct ;
    private String nom_produit ;
    private String description;
    private String photo;
    private float prix;
    private int stock;


    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Cart> carts = new ArrayList<>();

    //constructors
    public Product() {
    }

    public Product(String nom_produit, String description, String photo, float prix, int stock) {
        this.nom_produit = nom_produit;
        this.description = description;
        this.photo = photo;
        this.prix = prix;
        this.stock = stock;
    }

    // getters and setters ...
    public int getIdProduct() {
        return idProduct;
    }


    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }


    // le user.role ADMIN permet le CRUD sur les produits
    // le user client ne pourra que lister les produits .
    // le client pourra créer un panier

}
