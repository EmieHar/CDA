package Bases_Objet;

public class TestVoiture{
    public static void main(String[] args){
        Voiture v1 = new Voiture();
        v1.setCouleur("rouge");
        v1.setMarque("volvo");
        v1.setCarburant("essence");
        v1.setAnneeDeFabrication("2020");
        System.out.println(v1.marque);

        //dans cet exemple ça fonctionne car attribut déclaré en public, serait impossible si créé en private --> parle d'effet de bord
        v1.marque="lolilol";
        System.out.println(v1.marque);

    }
}