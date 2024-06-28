package org.example;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("valeur de X: ");
        int x = scan.nextInt();

        System.out.println("valeur de Y: ");
        int y = scan.nextInt();

        System.out.println("Avant permutation:\n valeur de x:" + x + "\n valeur de y: " + y );
        int z =  x;
        x = y;
        y = z;

        System.out.println("Après permutation:\n valeur de x: " + x + "\n valeur de y: " + y);

    }

}