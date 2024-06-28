package Injection_Dependance.src;

public class VoitureMoteur {
    private String color;
    private String marque;
    private String carburant;
    private String anneeDeFabrication;

    private Moteur moteur;

    public VoitureMoteur() {  }

    public VoitureMoteur(String color, String marque, String carburant, String anneeDeFabrication, Moteur moteur){
        this.color = color;
        this.marque = marque;
        this.carburant = carburant;
        this.anneeDeFabrication = anneeDeFabrication;
        this.moteur = moteur;
    }

    public void presentation(){
        System.out.printf("voiture de marque %s, fabriquée en: %s, de couleur %s, roulant avec le carburant: %s \r\n", this.marque,this.anneeDeFabrication, this.color, this.carburant);
        System.out.printf("Cylindrée : %.2f - nombre de cylindres : %d \r\n", this.moteur.getCylindree(), this.moteur.getNbcyl());
    }
    
}
