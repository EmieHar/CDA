package Bases_Objet;

public class Voiture2 {
   //attributs
   private String couleur ;
   private String marque;
   private String carburant;
   private String anneeDeFabrication; // par convention nom attribut composé est en camelCase

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

   public String getCouleur(){
    return this.couleur;
   }

   public String getMarque(){
    return this.marque;
   }

   public String getAnneeDeFabrication(){
    return this.anneeDeFabrication;
   }

   public String getCarburant(){
    return this.carburant;
   }

   public void presentation(){
        System.out.printf("Voiture de marque %s, de couleur %s, roulant au type de carburant %s", this.marque, this.couleur, this.carburant);
   }

}

