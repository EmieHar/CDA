package org.example.view;

import org.example.controller.MarketController;
import org.example.model.Customer;
import org.example.model.Producer;
import org.example.model.Product;

import java.util.List;
import java.util.Scanner;

public class ViewMarket {
    Scanner scan = null;


    //Saisis pour le producteur
    public String enterName() {
        scan = new Scanner(System.in);
        System.out.println("Nom:");
        return scan.nextLine();
    }

    public String enterFirstName() {
        scan = new Scanner(System.in);
        System.out.println("Prénom:");
        return scan.nextLine();
    }

    public String enterPhoneNumber() {
        scan = new Scanner(System.in);
        System.out.println("Votre numéro de téléphone:");
        return scan.nextLine();
    }

    public String enterEmail() {
        scan = new Scanner(System.in);
        System.out.println("Votre email:");
        return scan.nextLine();
    }

    public String enterPassword() {
        scan = new Scanner(System.in);
        System.out.println("Votre mot de passe:");
        return scan.nextLine();
    }

    public String enterAddress() {
        scan = new Scanner(System.in);
        System.out.println("Votre adresse:");
        return scan.nextLine();
    }

    public String enterProfessionalAddress() {
        scan = new Scanner(System.in);
        System.out.println("Votre adresse professionnelle:");
        return scan.nextLine();
    }

    public long enterSiretNumber() {
        scan = new Scanner(System.in);
        System.out.println("Votre numéro siret (14 chiffres):");
        return scan.nextLong();
    }


    //Saisis pour le produit
    public String enterNameProduct() {
        scan = new Scanner(System.in);
        System.out.println("Nom du produit:");
        return scan.nextLine();
    }

    public String enterDescription() {
        scan = new Scanner(System.in);
        System.out.println("Description du produit:");
        return scan.nextLine();
    }

    public String enterReference() {
        scan = new Scanner(System.in);
        System.out.println("Référence ou code barre du produit:");
        return scan.nextLine();
    }

    public String enterPhoto() {
        scan = new Scanner(System.in);
        System.out.println("Photo du produit:");
        return scan.nextLine();
    }

    public double enterPrice() {
        scan = new Scanner(System.in);
        System.out.println("Prix du produit à l'unité:");
        return scan.nextDouble();
    }

    public int enterStock() {
        scan = new Scanner(System.in);
        System.out.println("Nombre en stock:");
        return scan.nextInt();
    }

    //saisis pour la modification du produit
    public String updateNameProduct() {
        System.out.println("Nom du produit (touche 'Entrée' pour ignorer la mise à jour):");
        String input = scan.nextLine();
        // si l'utilisateur appuie sur Entrée sans texte, nextLine() renverra une chaîne vide
        // (input.isEmpty() sera vrai),
        // donc la méthode retournera null.
        // Sinon, valeur saisie par utilisateur sera retournée normalement.
        return input.trim().isEmpty() ? null : input;
    }

    public String updateDescription() {
        System.out.println("Description du produit (touche 'Entrée' pour ignorer la mise à jour):");
        String input = scan.nextLine();
        return input.trim().isEmpty() ? null : input;
    }

    public String updateReference() {
        System.out.println("Référence du produit (touche 'Entrée' pour ignorer la mise à jour):");
        String input = scan.nextLine();
        return input.trim().isEmpty() ? null : input;
    }

    public String updatePhoto() {
        System.out.println("Photo du produit (touche 'Entrée' pour ignorer la mise à jour):");
        String input = scan.nextLine();
        return input.trim().isEmpty() ? null : input;
    }

    public Double updatePrice() {
        System.out.print("Prix du produit (si pas de changement remettre le même prix): ");
        return scan.nextDouble();
    }

    public Integer updateStock() {
        System.out.print("Stock du produit (si pas de changement remettre le mêm stock): ");
        return scan.nextInt();
    }

    //affichage pour les producers
    public void getProducers(List<Producer> producers){
        if(producers != null){
            System.out.println("\n Liste de producteurs:");
            for(Producer producer : producers){
                System.out.println("\t - Nom: " + producer.getLastName() + " Prénom: " + producer.getFirstName());
                System.out.println("\t\tEmail: " + producer.getEmail());
                System.out.println("\t\tAdresse pro: " + producer.getProfessionalAddress());
                System.out.println("\t\tNuméro de téléphone: " + producer.getPhoneNumber() + "\n");
            }
        }
    }


    //affichage pour les products
    public void getProducts(List<Product> products){
        if(products != null){
            System.out.println("\n Liste des produits:");
            for(Product product : products){
                System.out.println("\t - Nom du produit: " + product.getNameProduct());
                System.out.println("\t\tDescription: " + product.getDescription());
                System.out.println("\t\tRéférence: " + product.getReference());
                System.out.println("\t\tPhoto: " + product.getPhoto() );
                System.out.println("\t\tPrix: " + product.getPrice());
                System.out.println("\t\tStock: " + product.getStock());
                System.out.println("\t\tProducteur: " +product.getProducer().getLastName() + " " + product.getProducer().getFirstName()  + "\n");

            }
        }
    }

    public void getProductsbyProducer(List<Product> products, Producer producer){
        if(products != null){
            System.out.println("\n Liste des produits du producteur: " + producer.getLastName() + " " + producer.getFirstName());
            for(Product product : products){
                System.out.println("\t - Nom du produit: " + product.getNameProduct());
                System.out.println("\t\tDescription: " + product.getDescription());
                System.out.println("\t\tRéférence: " + product.getReference());
                System.out.println("\t\tPhoto: " + product.getPhoto() );
                System.out.println("\t\tPrix: " + product.getPrice());
                System.out.println("\t\tStock: " + product.getStock() + "\n");
            }
        }
    }


    //affichage pour les customers
    public void getCustomers(List<Customer> customers){
        if(customers != null){
            System.out.println("\n Liste des clients:");
            for(Customer customer : customers){
                System.out.println("\t - Nom: " + customer.getLastName() + " Prénom: " + customer.getFirstName());
                System.out.println("\t\tEmail: " + customer.getEmail());
                System.out.println("\t\tAdresse : " + customer.getAddress());
                System.out.println("\t\tNuméro de téléphone: " + customer.getPhoneNumber() + "\n");
            }
        }
    }
}
