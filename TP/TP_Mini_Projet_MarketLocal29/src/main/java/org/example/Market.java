package org.example;

import org.example.controller.MarketController;

public class Market {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MarketController mc = new MarketController();
        //mc.createProducer();
        //mc.getProducers();

        //mc.createProduct(2);
        //mc.getProducts();

        //mc.createCustomer();
        //mc.getCustomers();
        //mc.customerConnexion();

        //mc.updateProduct(3);

        //mc.getProductsByProducer(2);

        //mc.getProducersAndTheirProducts();

        //mc.customerConnexion();
        mc.addProductToBasket(1,1,10);
    }
}
