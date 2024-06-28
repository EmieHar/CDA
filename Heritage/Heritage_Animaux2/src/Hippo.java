package Heritage.Heritage_Animaux2.src;

public class Hippo extends Animaux{

    public Hippo(String nom, String picture, String food, String hunger, String boundaries, String location) {
        super(nom, picture, food, hunger, boundaries, location);
    }

    public void makeNoise(){
        super.makeNoise();
        System.out.println("Il grogne\r\n");
    }

    public void eat(){
        super.eat();
        System.out.println("l'herbe des prairies\r\n");
    }


}
