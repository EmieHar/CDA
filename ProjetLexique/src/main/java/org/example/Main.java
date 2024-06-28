package org.example;

import org.example.controller.MotController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        MotController mc = new MotController();
        mc.ajouterMot();

    }
}