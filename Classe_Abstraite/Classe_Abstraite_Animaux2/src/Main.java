package Classe_Abstraite.Classe_Abstraite_Animaux2.src;

public class Main {
    public static void main(String[] args){
        Hippo hipopo = new Hippo ("hipopo","whoaw", "de la salade", "toujours faim", "dans la marre", "afrique");
        hipopo.presentation();
        hipopo.makeNoise();
        hipopo.roam();

        Lion txipi = new Lion();
        txipi.eat();
        txipi.makeNoise();
        txipi.roam();

        Cat inox = new Cat();
        inox.eat();
        inox.makeNoise();
        inox.roam();

        Wolf toto = new Wolf();
        toto.roam();
        toto.eat();
        toto.makeNoise();

    }
}