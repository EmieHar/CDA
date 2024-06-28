package Heritage.Heritage_Animaux.src;

public class Main {
    public static void main(String[] args){
        Mammifere elephant = new Mammifere ("Elephant d'Asie");
        System.out.println(elephant.getNom());
        elephant.setMoisGestation(8);
        System.out.println(elephant.getMoisGestation());

        Chien txipi = new Chien("Txipi");
        txipi.mange();
        txipi.aboie();
    }
}
