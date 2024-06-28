package Bases_Objet;

public class Voiture3 {
    //attributs
    private String couleur ;
    private String marque;
    private String carburant;
    private String anneeDeFabrication; // par convention nom attribut composé est en camelCase
    private int quantiteDeCarburant = 0;
    private Boolean demarree;
    
    //constructeurs = méthodes particulières
    public Voiture3(){}

    public Voiture3(String color, String marque, String carburant, String anFabric){
        this.couleur = color;
        this.marque = marque;
        this.carburant = carburant;
        this.anneeDeFabrication = anFabric;
        this.demarree = false;
       }

    //méthodes 
    public Voiture3 setCouleur(String color) {
        this.couleur = color;
        return this;
    }
 
    public Voiture3 setMarque(String m){
        this.marque = m;
        return this;
    }
 
    public Voiture3 setCarburant(String carbu){
        this.carburant = carbu;
        return this;
    }
 
    public Voiture3 setAnneeDeFabrication(String annee) {
        this.anneeDeFabrication = annee;
        return this;
    }

 
    public void presentation(){
         System.out.printf("Voiture de marque %s, de couleur %s, roulant au type de carburant %s %n", this.marque, this.couleur, this.carburant);
    }

    //faire une methode qui permet de remplir le reservoir
    //faire une methode pour demarrer la voiture
    // faire une methode pour arreter la voiture
 
    public void remplirReservoir(){
        if(this.quantiteDeCarburant == 0){
            System.out.println("Je pousse la voiture jusqu'à la station service la plus proche");
            this.quantiteDeCarburant = 100;
        }
        else if(this.quantiteDeCarburant<10 && this.quantiteDeCarburant>0){
            System.out.println("Je me rend à la station service et je fais le plein.");
            this.quantiteDeCarburant =100;
        }
        else{
            System.out.println("J'ai encore le temps avant de faire le plein");
        }
    }

    public void demarrage(){
        if(!this.demarree && quantiteDeCarburant!= 0 ){
            System.out.println("Je met la clef et tourne le contact");
            this.demarree = true;
            System.out.println("Vroum vroum");
        }else{
            System.out.println("Je met la clef et tourne le contact mais rien ne se passe");
        }
    }

    public void stop(){
        if(this.demarree){
            System.out.println("je stoppe le moteur");
            this.demarree = false;
        }
        else{
            System.out.println("le moteur ne tourne pas, pas la peine de l'arreter");
        }
    }


 }
 
 
