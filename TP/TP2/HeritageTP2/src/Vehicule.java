package HeritageTP2.src;

public abstract class Vehicule {

    private String marque;
    private String modele;

    public Vehicule(){};

    public Vehicule(String marque, String modele) {
        this.marque = marque;
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }
    public String getModele() {
        return modele;
    }

    public abstract boolean demarrer();
    public abstract void arreter();
    public abstract void faireLePlein(float volumeCarburant);

    public abstract void rouler(float consommation) throws PanneEssenceException;
}
