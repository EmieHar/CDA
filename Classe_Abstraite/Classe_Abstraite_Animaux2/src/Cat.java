package Classe_Abstraite.Classe_Abstraite_Animaux2.src;

public class Cat extends Feline{

    public void makeNoise(){
        System.out.println("Cet animal fait ce bruit:");
        System.out.println("Il ronronne, miaule, feule\r\n");
    }

    public void eat(){
        System.out.println("Cet animal mange:");
        System.out.println("Des croquettes, des rongeurs, des oiseaux\r\n");
    }
}
