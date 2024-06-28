package Bases_Objet;

public class Voiture {
    //attributs
    public String couleur ;
    public String marque;
    public String carburant;
    public String anneeDeFabrication; // par convention nom attribut composé est en camelCase

    //méthodes 
    public void setCouleur(String color) {
        this.couleur = color;
    }

    public void setMarque(String m){
        this.marque = m;
    }

    public void setCarburant(String carbu){
        this.carburant = carbu;
    }

    public void setAnneeDeFabrication(String annee) {
        this.anneeDeFabrication = annee;
    }
}
