package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner scan = new Scanner(System.in);
        System.out.println("Entrer un nombre:");
        int result = scan.nextInt();

        if (result == 0){
            System.out.println("Le nombre est 0 (et il est pair)");
        } else if ( result < 0){
            System.out.println("Le nombre est négatif ");
        } else {
            System.out.println("Le nombre est positif ");
        }

        int reste = result % 2;

        if( reste == 0){
            System.out.println("et pair");
        } else {
            System.out.println("et impair");
        }
    }
}