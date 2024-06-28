package org.example.controller;

import org.example.dao.CustomerDAO;
import org.example.dao.OrderDAO;
import org.example.dao.ProducerDAO;
import org.example.dao.ProductDAO;
import org.example.model.Customer;
import org.example.model.Producer;
import org.example.model.Product;
import org.example.view.ViewMarket;

import java.util.*;

public class MarketController {
    private ProducerDAO producerDao;
    private ProductDAO productDao;
    private CustomerDAO customerDAO;
    private OrderDAO orderDao;
    private ViewMarket marketView;

    //Contrutor
    public MarketController(){
        this.producerDao = new ProducerDAO();
        this.productDao = new ProductDAO();
        this.customerDAO = new CustomerDAO();
        this.orderDao = new OrderDAO();
        this.marketView = new ViewMarket();
    }

    //--------------------------------------- méthodes pour les Producers ----------------------------------------------------------
    public void createProducer(){
        //récupération des données saisies
        String lastname = marketView.enterName();
        String firstname = marketView.enterFirstName();
        String phoneNumber = marketView.enterPhoneNumber();
        String email = marketView.enterEmail();
        String address = marketView.enterAddress();
        String professionalAddress = marketView.enterProfessionalAddress();
        long siretNumber = marketView.enterSiretNumber();
        String password = marketView.enterPassword();

        //création de l'objet Producteur
        Producer producer = new Producer(lastname,firstname,phoneNumber,email,address,password, professionalAddress, siretNumber);

        //passer l'objet à la méthode de création
        producerDao.createProducer(producer);

        System.out.println("Nouveau producteur créé avec succès");
    }

    public void getProducers(){
        List<Producer> producers = producerDao.getProducers();
        marketView.getProducers(producers);
    }

    //--------------------------------------- méthodes pour les Products ----------------------------------------------------------
    public void createProduct(int idProducer){
        //récupération des données saisies
        String name = marketView.enterNameProduct();
        String description = marketView.enterDescription();
        String reference = marketView.enterReference();
        String photo = marketView.enterPhoto();
        double price = marketView.enterPrice();
        int stock = marketView.enterStock();

        //création de l'objet Produit
        Product product = new Product(name,description,reference,photo,price,stock);

        //récupération objet Producteur à partir de son id
        Producer producer = producerDao.getProducerById(idProducer);

        //passer les objets à la méthode de création
        producerDao.createProduct(product, producer);

        System.out.println("Nouveau produit créé avec succès");
    }


    public void updateProduct(int idProduct){
        String name = marketView.enterNameProduct();
        String description = marketView.enterDescription();
        String reference = marketView.enterReference();
        String photo = marketView.enterPhoto();
        double price = marketView.enterPrice();
        int stock = marketView.enterStock();

        Product updateProduct = new Product(name,description,reference,photo,price,stock);

        Product product = productDao.getProductById(idProduct);

        producerDao.updateProduct(updateProduct, product);
    }


    public void getProducts(){
        List<Product> products = productDao.getProducts();
        marketView.getProducts(products);
    }


    public void getProductsByProducer(int idProducer){
        Producer producer = producerDao.getProducerById(idProducer);
        List<Product> products = productDao.getProductsByProducer(producer);
        marketView.getProductsbyProducer(products, producer);
    }

    public void getProducersAndTheirProducts(){
        List<Producer> producers = producerDao.getProducers();
        for(Producer producer: producers){
            List<Product> products = productDao.getProductsByProducer(producer);
            marketView.getProductsbyProducer(products, producer);
        }
    }

    public void getProducersWithProducts() {
        List<Product> products = productDao.getProducersWithProducts();
        Map<Producer, List<Product>> producerProductsMap = new HashMap<>();

        for (Product product : products) {
            Producer producer = product.getProducer();
            producerProductsMap
                    .computeIfAbsent(producer, k -> new ArrayList<>())
                    .add(product);
        }

        for (Map.Entry<Producer, List<Product>> entry : producerProductsMap.entrySet()) {
            Producer producer = entry.getKey();
            List<Product> productsList = entry.getValue();
            marketView.getProductsbyProducer(productsList, producer);
        }
    }

    public void addProductToBasket(int customerId, int productId, int quantity){
        customerDAO.addProductToBasket(customerId, productId, quantity);
    }

    //--------------------------------------- méthodes pour les Customers ----------------------------------------------------------
    public void createCustomer(){
        String lastname = marketView.enterName();
        String firstname = marketView.enterFirstName();
        String phoneNumber = marketView.enterPhoneNumber();
        String email = marketView.enterEmail();
        String address = marketView.enterAddress();
        String password = marketView.enterPassword();

        Customer customer = new Customer(lastname,firstname,phoneNumber,email,address,password);
        customerDAO.createCustomer(customer);
    }

    public void customerConnexion(){
        String email = marketView.enterEmail();
        String password = marketView.enterPassword();
        customerDAO.customerConnexion(email, password);
    }

    public void getCustomers(){
        List<Customer> customers = customerDAO.getCustomers();
        marketView.getCustomers(customers);
    }

}
