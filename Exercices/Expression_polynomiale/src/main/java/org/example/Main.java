package org.example;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrez a (int): ");
        int a = scan.nextInt();

        System.out.println("Entrez b (int): ");
        int b = scan.nextInt();

        System.out.println("Entrez c (int): ");
        int c = scan.nextInt();

        System.out.println("Entrez x (double): ");
        double x = scan.nextDouble();

        double result = calculer(a,b,c,x);

        System.out.println("la valeur du polynome est: " + result);
    }

    public static double calculer(int a, int b, int c, double x){
        int somme = a + b;
        int somme_div_2 = somme / 2;
        double x_cube = x * x * x;
        double x_carre = x * x;
        int somme_carree = somme * somme;

        double arg1 = somme_div_2 * x_cube;
        double arg2 = somme_carree * x_carre;

        double polynome =  arg1 + arg2 + somme + c;

        return polynome;
    }
}