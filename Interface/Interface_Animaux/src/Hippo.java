package Interface.Interface_Animaux.src;

public class Hippo extends Animaux{

    public Hippo(String nom, String picture, String food, String hunger, String boundaries, String location) {
        super(nom, picture, food, hunger, boundaries, location);
    }

    public void makeNoise(){
        System.out.println("Cet animal fait ce bruit:");
        System.out.println("Il grogne\r\n");
    }

    public void eat(){
        System.out.println("Cet animal mange:");
        System.out.println("l'herbe des prairies\r\n");
    }

    public void roam(){
        System.out.println("Je me ballade, nous nous balladons");
    }


}
