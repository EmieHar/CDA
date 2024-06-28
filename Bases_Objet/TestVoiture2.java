package Bases_Objet;
import java.util.ArrayList;

public class TestVoiture2 {
    public static void main(String[] args){
        Voiture2 v1 = new Voiture2();
        v1.setCouleur("rouge");
        v1.setMarque("volvo");
        v1.setCarburant("essence");
        v1.setAnneeDeFabrication("2020");
       
        System.out.println(v1.getCouleur());

        //v1.presentation();

        Voiture2 v2 = new Voiture2();
        v2.setCouleur("bleue");
        v2.setMarque("skoda");
        v2.setCarburant("diesel");
        v2.setAnneeDeFabrication("2018");

        Voiture2 v3 = new Voiture2();
        v3.setCouleur("verte");
        v3.setMarque("renault");
        v3.setCarburant("electrique");
        v3.setAnneeDeFabrication("2023");

        //generiques avec l'opérateur diamant
         ArrayList<Voiture2> listCars = new ArrayList<Voiture2>();
         listCars.add(v1);
         listCars.add(v2);
         listCars.add(v3);
 
         //System.out.println(listCars);

         listCars.forEach( (c) -> { System.out.println(c.getMarque());});

         Voiture2 v4 = listCars.get(0);
         System.out.println(v4.getMarque());

         listCars.remove(0);
         System.out.println(listCars.size());

        
    }
}
