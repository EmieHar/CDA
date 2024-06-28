public class Personne {
    private String nom;
    private String prenom;
    private int age;
    private Adresse adresse;

    //constructeur
    public Personne(String nom, String prenom, int age, Adresse adresse){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
    }

    //getters setters
    public String getNom(){
        return  nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }

    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public int getAge(){
        return  age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public Adresse getAdresse(){
        return adresse;
    }
    public void setAdresse(Adresse adresse){
        this.adresse = adresse;
    }

    //méthode redefinie
    public String toString() {
        return prenom + " " + nom + " " + age + " ans, habite au " + adresse ;
    }

}
