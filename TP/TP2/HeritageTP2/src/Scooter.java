package HeritageTP2.src;

public class Scooter extends VehiculeAMoteur {
    public Scooter(String marque, String modele, float volume_reservoir) {
        super(marque, modele, volume_reservoir);
    }

    public void rouler(float consommation) throws PanneEssenceException  {
        // Démarrer le moteur si ce n'est pas déjà fait
        if (!moteur.isDemarre()) {
            if (!moteur.demarrer()) {
                throw new PanneEssenceException("Impossible de démarrer le moteur. Pas assez de carburant.");
            }
        }
        // Utiliser le carburant pour rouler
        boolean carburant = moteur.utiliser(consommation);
        if (!carburant) throw new PanneEssenceException("Panne d'essence");

    }

    @Override
    public String toString() {
        return "Je suis le véhicule " + this.getMarque() + ' ' + this.getModele() + "\n" +
                "il reste " + moteur.getVolumeReservoir() + " litres dans le réservoir \n" +
                "Je viens de consommer " + moteur.getVolumeTotal() + " litres de carburant\n"
                ;
    }

}

