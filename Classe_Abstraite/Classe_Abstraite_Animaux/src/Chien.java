package Classe_Abstraite.Classe_Abstraite_Animaux.src;

public class Chien extends Mammifere {
    //constructeur
    public Chien(String nom){
        super(nom);
    }

    public void aboie(){
        System.out.println("Wouaf Wouaf");
    }
}
