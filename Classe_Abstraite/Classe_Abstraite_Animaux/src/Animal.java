package Classe_Abstraite.Classe_Abstraite_Animaux.src;

abstract public class Animal {

    //attributs
    private String nom;

    public Animal(String nom){
        this.nom = nom;
    }

    public Animal(){}

    public Animal setNom(String nom){
        this.nom = nom;
        return this;
    }

    public String getNom(){
        if (this.nom != null){
            return this.nom;
        } else {
            return "pas de nom";
        }
    }

    abstract public void mange();

}
