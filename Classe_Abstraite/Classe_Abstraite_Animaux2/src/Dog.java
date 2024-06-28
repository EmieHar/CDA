package Classe_Abstraite.Classe_Abstraite_Animaux2.src;

public class Dog extends Canine{

    public void makeNoise(){
        System.out.println("Cet animal fait ce bruit:");
        System.out.println("Il aboie\r\n");
    }

    public void eat(){
        System.out.println("Cet animal mange:");
        System.out.println("Des croquettes, des os, de la viande\r\n");
    }
}
