package Heritage.Heritage_Animaux2.src;

public class Dog extends Canine{

    public void makeNoise(){
        super.makeNoise();
        System.out.println("Il aboie\r\n");
    }

    public void eat(){
        super.eat();
        System.out.println("Des croquettes, des os, de la viande\r\n");
    }
}
