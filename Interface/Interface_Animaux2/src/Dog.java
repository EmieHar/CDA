package Interface.Interface_Animaux2.src;

public class Dog extends Canine implements Pet {

    public void makeNoise(){
        System.out.println("Cet animal fait ce bruit:");
        System.out.println("Il aboie\r\n");
    }

    public void eat(){
        System.out.println("Cet animal mange:");
        System.out.println("Des croquettes, des os, de la viande\r\n");
    }

    @Override
    public void beFriendly() {
        System.out.println("remue la queue et se leche la truffe");
    }

    @Override
    public void play() {
        System.out.println("aboie, est tout fou, ramène la baballe");
    }

}
