package Interface.Interface_Animaux.src;

public class Wolf extends Canine{

    public void makeNoise(){
        System.out.println("Cet animal fait ce bruit:");
        System.out.println("Il hurle\r\n");
    }

    public void eat(){
        System.out.println("Cet animal mange:");
        System.out.println("Du lièvre, des reptiles, du gibier ou des batraciens\r\n");
    }
}
