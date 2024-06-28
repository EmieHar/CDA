package Injection_Dependance.src;

public class Moteur {
    //attributs
    private float cylindree;
    private int nbcyl;

    //constructeur
    public Moteur(float cyl, int nbcyl) {
        this.cylindree = cyl;
        this.nbcyl = nbcyl;
    }

    //methodes
    public float getCylindree(){
        return this.cylindree;
    }

    public int getNbcyl(){
        return this.nbcyl;
    }
}
