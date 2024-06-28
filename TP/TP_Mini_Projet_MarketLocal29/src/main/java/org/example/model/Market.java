package org.example.model;

import java.util.List;

public class Market {
    private int idMarket;
    private List<Producer> producers;
    private List<Product>products;

    public List<Producer> getProducers() {
        return producers;
    }

    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }

    public int getIdMarket() {
        return idMarket;
    }

    public void setIdMarket(int idMarket) {
        this.idMarket = idMarket;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



    public Market(int idMarket, List<Producer> producers, List<Product> products) {
        this.idMarket = idMarket;
        this.producers = producers;
        this.products = products;
    }

    public void command(List<Product>products) {
        this.products = products;
    }
}
