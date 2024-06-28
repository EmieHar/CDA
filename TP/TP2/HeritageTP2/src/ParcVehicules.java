package HeritageTP2.src;

//pour pouvoir utiliser random
import java.util.Random;

public class ParcVehicules {

    // private: pour encapsulation donc constante uniquement accessible dans la classe ParcVehicules

    //static: indique que constante est associé à la classe ParcVehicule et non à ses instances, donc chaque instance de ParcVehicules partagera mêm valeur de tailleTableau

    //final: indique que valeur de la constante ne peut être modifiée une fois définie.

    private static final int TailleTableau =10;
    private Vehicule[] vehicules = new Vehicule[TailleTableau];
    private Random random = new Random();

    //constructeur
    public ParcVehicules(Vehicule[] vehicules){
        this.vehicules = vehicules;
    }

    //accesseurs et modificateur (get et set)
    public Vehicule getVehicule(int index){
        return vehicules[index];
    }

    public void setVehicule(int index, Vehicule vehicule){
        vehicules[index] = vehicule;
    }

    public void controlerVehicules(){

        System.out.println("Test des véhicules du parc\n");

        for (Vehicule vehicule : vehicules){

            if(vehicule != null) {

                String marque = vehicule.getMarque();
                String modele = vehicule.getModele();

                //vérifier dynamiquement le type du véhicule
                if (vehicule instanceof Voiture){
                    String type = "Voiture";
                    System.out.println("Test du véhicule: "+ marque + " " + modele + " de type: "+ type);
                } else if (vehicule instanceof Scooter){
                    String type = "Scooter";
                    System.out.println("Test du véhicule: "+ marque + " " + modele + " de type: "+ type);
                }

                try {
                    vehicule.demarrer();
                    //nombre de trajet aléatoire entre 1 et 5 km
                    float trajet = 1 + random.nextInt(5);
                    vehicule.rouler(trajet);

                } catch (PanneEssenceException ex) {
                    //nb litres ajouté aléatoire (entre 1 et 10)
                    float carbuAjouté = 1 + random.nextInt(10);
                    vehicule.faireLePlein(carbuAjouté);

                    try {
                        //nouveau trajet aléatoire entre 1 et 5 km
                        float trajet = 1 + random.nextInt(5);
                        vehicule.rouler(trajet);

                    } catch (PanneEssenceException e) {
                        System.out.println("Encore une panne d'essence!\n");
                    }
                }

            }
        }
    }


}
