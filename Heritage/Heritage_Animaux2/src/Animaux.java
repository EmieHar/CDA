package Heritage.Heritage_Animaux2.src;

public class Animaux {

    private String picture;
    private String food;
    private String hunger;
    private String boundaries;
    private String location;
    private String nom;

    public Animaux(String nom, String picture, String food, String hunger, String boundaries, String location){
        this.nom = nom;
        this.picture = picture;
        this.food = food;
        this.hunger = hunger;
        this.boundaries = boundaries;
        this.location = location;
    }

    public Animaux(){}

    public Animaux setPicture(String picture){
        this.picture = picture;
        return this;
    }

    public String getPicture(){
        if (this.picture != null){
            return this.picture;
        } else {
            return "pas de photo";
        }
    }

    public Animaux setFood(String food){
        this.food = food;
        return this;
    }

    public String getFood(){
       return this.food;
    }

    public Animaux setHunger(String hunger){
        this.hunger = hunger;
        return this;
    }

    public String getHunger(){
        return this.hunger;
    }

    public Animaux setBoundaries(String boundaries){
        this.boundaries = boundaries;
        return this;
    }

    public String getBoundaries(){
        return this.boundaries;
    }

    public Animaux setLocation(String location){
        this.location = location;
        return this;
    }

    public String getLocation(){
        return this.location;
    }

    public void makeNoise(){
        System.out.println("Cet animal fait ce bruit:");
    }

    public void eat(){
        System.out.println("Cet animal mange:");
    }

    public void sleep(){
        System.out.println("Cet animal dort au moins (en heure):");
    }

    public void roam(){
        System.out.println("Je me ballade, nous nous balladons");
    }

    public void presentation(){
        System.out.printf("Le: %s, photo: %s, a pour nourriture préférée: %s, mange: %s, a pour territoire: %s,est localisé %s\r\n", this.nom, this.picture, this.food, this.hunger,this.boundaries, this.location );
    }


}