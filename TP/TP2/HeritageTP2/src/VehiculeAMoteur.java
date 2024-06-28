package HeritageTP2.src;

public abstract class VehiculeAMoteur extends Vehicule{

    // protected permet que moteur ne soit accessible
    protected Moteur moteur;

    public VehiculeAMoteur(String marque, String modele, float volume_reservoir) {
        super(marque, modele);
        this.moteur = new Moteur(volume_reservoir);
    }

    public boolean demarrer() {
       return moteur.demarrer();
   }

   public void arreter(){
       moteur.arreter();
   }

    @Override
    public void faireLePlein(float volumeCarburant) {
       moteur.arreter();
       moteur.faireLePlein(volumeCarburant);
       moteur.demarrer();
    }

    public abstract void rouler(float consommation) throws PanneEssenceException;

}
