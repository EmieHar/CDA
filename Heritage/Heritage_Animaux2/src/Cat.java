package Heritage.Heritage_Animaux2.src;

public class Cat extends Feline{

    public void makeNoise(){
        super.makeNoise();
        System.out.println("Il ronronne, miaule, feule\r\n");
    }

    public void eat(){
        super.eat();
        System.out.println("Des croquettes, des rongeurs, des oiseaux\r\n");
    }
}
