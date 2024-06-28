package TP.TP1.CalculatriceTP1.src;

public class Main {
    public static void main(String[] args) {
        double resultat;

        // Test de l'addition
        resultat = Calculatrice.calculer('+', 5, 3);
        System.out.println("5 + 3 = " + resultat);

        // Test de la soustraction
        resultat = Calculatrice.calculer('-', 5, 3);
        System.out.println("5 - 3 = " + resultat);

        // Test de la multiplication
        resultat = Calculatrice.calculer('*', 5, 3);
        System.out.println("5 * 3 = " + resultat);

        // Test de la division
        resultat = Calculatrice.calculer('/', 5, 3);
        System.out.println("5 / 3 = " + resultat);

        // Test de la division par zéro
        try {
            resultat = Calculatrice.calculer('/', 5, 0);
            System.out.println("5 / 0 = " + resultat);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test avec un opérateur invalide
        try {
            resultat = Calculatrice.calculer('%', 5, 3);
            System.out.println("5 % 3 = " + resultat);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.printf("15 / 0 = %2.2f\n", Calculatrice.calculer('/', 15, 0));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            System.out.printf("1 ! 2 = %2.2f\n",Calculatrice.calculer('!', 1, 2));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}