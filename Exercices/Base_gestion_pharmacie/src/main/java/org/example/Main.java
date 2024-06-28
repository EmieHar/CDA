package org.example;
import java.util.Scanner;
class GestionPharmacie {
    protected static Scanner scanner = new Scanner(System.in);

    /**
     * Le programme principal  crée un objet Pharmacie
     * sur lequel les opérations suivantes peuvent être effectuées:
     * - achat (d'un médicament par un client),
     * - approvisionnement (ajout d'un médicament au stock)
     * - affichage (des données relatives à la pharmacie
     */
    public static void main(String args[]) {
        Client[] clients = new Client[2];
        Medicament[] medicaments = new Medicament[2];

        clients[0] = new Client("Malfichu", 0.0);
        clients[1] = new Client("Palichon", 0.0);

        medicaments[0] = new Medicament("Aspiron", 20.40, 5);
        medicaments[1] = new Medicament("Rhinoplexil", 19.15, 5);

        Pharmacie1 p = new Pharmacie1(clients, medicaments);

        int choix;
        do {
            choix = menu();

            switch (choix) {
                case 1:
                    p.achat();
                    break;
                case 2:
                    p.approvisionnement();
                    break;
                case 3:
                    p.affichage();
                    break;
                case 4:
                    quitter();
                    break;
            }
        } while (choix < 4);
    }
    // Les méthodes utilitaires

    static int menu() {
        int choix = 0;
        System.out.println();
        System.out.println();
        System.out.println("1 : Achat de médicament");
        System.out.println("2 : Approvisionnement en  médicaments");
        System.out.println("3 : Etats des stocks et des crédits");
        System.out.println("4 : Quitter");
        while ((choix != 1) && (choix != 2) && (choix != 3) && (choix != 4)) {
            choix = scanner.nextInt();
        }
        return choix;
    }

    static void quitter() {
        System.out.println("Programme terminé!");
    }
}


// Les classes d'objets

class Pharmacie1 {
    // une pharmacie c'est une liste de client et
    // une liste de médicaments
    private Client[] clients;;
    private Medicament[] medicaments;

    public Pharmacie1(Client[] cs, Medicament[] ms) {
        clients = cs;
        medicaments = ms;
    }

    public Client[] getClients() {
        return this.clients;
    }

    public Medicament[] getMedicaments() {
        return this.medicaments;
    }

    /**
     * Permet à un client d'acheter un médicament.
     * si le client est connu de la pharmacie, son crédit
     * va diminuer en fonction de son paiement.
     * Le stock associé au médicament va diminuer
     */
    public void achat() {
        Client client = this.lireClient();
        Medicament medicament = this.lireMedicament();

        double paiement = lirePaiement();
        int quantite = lireQuantite();

        if (quantite <= medicament.getStock()) {
            medicament.diminuerStock(quantite);
            client.augmenterCredit((medicament.getPrix() * quantite) - paiement);
        } else {
            System.out.println("Achat Impossible. Quantité insuffisante");
        }
    }

    /**
     * Permet à la pharmacie de s'approvisionner en un
     * médicament connu.
     */
    public void approvisionnement() {
        Medicament medicament = this.lireMedicament();
        System.out.println("Donner la Quantité : ");
        int quantite = GestionPharmacie.scanner.nextInt();
        medicament.augmenterStock(quantite);
    }

    /**
     * Affichage des stocks et des crédits de la pharmacie
     */
    public void affichage() {

        System.out.println("Affichage des stocks");
        for (int i = 0; i < medicaments.length; i++) {
            System.out.println("Stock du médicament " + medicaments[i].getNom()
                    + " :" + medicaments[i].getStock());
        }

        System.out.println("Affichage des crédits");
        for (int i = 0; i < clients.length; i++) {
            System.out.println("Crédit du client " + clients[i].getNom()
                    + " :" + clients[i].getCredit());
        }
    }

    /**
     * Retourne l'objet Client associé à un nom (String)
     * Le nom est lu et redemandé tant qu'il ne correspond
     * pas au nom d'un client connu de la pharmacie
     */
    public Client lireClient() {
        String nom;
        boolean trouve = false;
        Client c = null;
        System.out.println("Nom du client?:");

        do {
            nom = GestionPharmacie.scanner.nextLine();
            for (int i = 0; (!trouve && i < clients.length); i++) {
                if ((clients[i].getNom()).equals(nom)) {
                    trouve = true;
                    c = clients[i];
                }
            }
            if (!trouve) {
                System.out.println("Client inconnu. Veuilliez recommencer");
            }
        } while (!trouve);

        return c;
    }

    /**
     * Retourne l'objet Medicament associé à un nom (String)
     * Le nom est lu et redemandé tant qu'il ne correspond
     * pas au nom d'un médicament connu de la pharmacie
     */
    public Medicament lireMedicament() {
        String nom;
        boolean trouve = false;
        Medicament m = null;
        System.out.println("Nom du medicament?:");

        do {
            nom = GestionPharmacie.scanner.nextLine();
            for (int i = 0; (!trouve && i < medicaments.length); i++) {
                if ((medicaments[i].getNom()).equals(nom)) {
                    trouve = true;
                    m = medicaments[i];
                }
            }
            if (!trouve) {
                System.out.println("Médicament inconnu. Veuilliez recommencer");
            }
        } while (!trouve);

        return m;
    }


    static double lirePaiement() {
        System.out.println("quel est le montant du paiement?");
        return GestionPharmacie.scanner.nextDouble();
    }

    static int lireQuantite() {
        System.out.println("quelle est la quantité achetée?");
        return GestionPharmacie.scanner.nextInt();
    }

}


class Client {
    // Un client est caractérisé par son nom et un crédit.
    private String nom = "";
    private double credit = 0.0;

    public Client(String nom, double credit) {
        this.nom = nom;
        this.credit = credit;
    }

    public void augmenterCredit(double montant) {
        credit = credit + montant;
    }

    public void diminuerCredit(double montant) {
        credit = credit - montant;
    }

    public double getCredit() {
        return credit;
    }

    public String getNom() {
        return nom;
    }
}


class Medicament {
    // un médicament a un nom, un prix et une quantité en stock
    private String nom;
    private double prix;
    private int stock;

    public Medicament(String nom, double prix, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }

    public void augmenterStock(int quantite) {
        stock = stock + quantite;
    }

    public void diminuerStock(int quantite) {
        stock = stock - quantite;
    }

    public int getStock() {
        return stock;
    }

    public double getPrix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }
}
