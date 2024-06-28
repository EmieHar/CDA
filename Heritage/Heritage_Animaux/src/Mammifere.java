package Heritage.Heritage_Animaux.src;

public class Mammifere extends Animal {

    private int moisGestation;

    public Mammifere(String nom){
        //mot clé pour utiliser le constructeur hérité du parent Animal
        super(nom);
    }

    public void setMoisGestation(int moisGestation) {
        this.moisGestation = moisGestation;
    }

    /* public void getMoisGestation(int moisGestation) {
        this.moisGestation = moisGestation;
    }*/

    public int getMoisGestation(){
        return moisGestation;
    }

    public String getNom(){
        //surcharge méthode getNom de Animal == override
        return super.getNom();
    }
}