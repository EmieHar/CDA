package Interface.Interface_Animaux2.src;

public class Cat extends Feline implements Pet {

    public void makeNoise(){
        System.out.println("Cet animal fait ce bruit:");
        System.out.println("Il ronronne, miaule, feule\r\n");
    }

    public void eat(){
        System.out.println("Cet animal mange:");
        System.out.println("Des croquettes, des rongeurs, des oiseaux\r\n");
    }

    @Override
    public void beFriendly() {
        System.out.println("miaou ronronronron\r\n");
    }

    @Override
    public void play() {
        System.out.println("cours comme un débile après le laser\r\n");
    }
}
