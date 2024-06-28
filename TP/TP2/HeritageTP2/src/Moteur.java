package HeritageTP2.src;

public class Moteur {

    //nb de litres dans le réservoir
    private float volume_reservoir ;
    //nb total de litres que moteur a reçu au fil de pleins effectues
    private float volume_total ;
    private boolean demarre ;

    public Moteur(){};

    public Moteur(float volume_reservoir) {
        this.volume_reservoir = volume_reservoir;
        this.volume_total = 0;
        this.demarre = false;
    }


    // Getters = accesseurs
    public float getVolumeReservoir() {
        return volume_reservoir;
    }


    public float getVolumeTotal() {
        return volume_total;
    }


    public boolean isDemarre() {
        return demarre;
    }


    public boolean demarrer() {
        //demarrer utilise 1/10 de litre de carburant -> pour démarrer besion au mini de 0.1 litre
        if (!demarre && volume_reservoir >= 0.1f) {
            demarre = true;

            //consomme 0.1l
            volume_reservoir -= 0.1f;
            System.out.println("Je démarre. Niveau de carburant restant: " + volume_reservoir + " litres.");

            //retourne bouléen pour dire opération à réussi
            return true;

        } else {
            System.out.println("Impossible de démarrer.");
            return false;
        }
    }

//    public float utiliser(float volCarbuPourTrajet){
//        //carburant utilisé si moteur démarré
//        if (demarre){
//            //conso mini pour 1 trajet (consommation effective) = VolCarbuPourTrajet OU volume restant dans réservoir (si volume restant < VolCarburantPourTrajet)
//            float volume_dispo = volume_reservoir - volCarbuPourTrajet;
//
//            if(volume_dispo <= 0 ) {
//
//                    System.out.println("Panne d'essence.");
//                    demarre = false;
//                    volume_reservoir = 0;
//                    return volume_reservoir;
//
//            } else {
//                float consoEffective = volCarbuPourTrajet;
//
//                volume_reservoir -= consoEffective;
//
//                System.out.println("pour le trajet il faut: " + volCarbuPourTrajet + " litres de carburant. Après trajet il restera: " + volume_reservoir + "litres dans le réservoir");
//
//                return volume_reservoir;
//            }
//
//        } else {
//            System.out.println("Utilisation impossible. Moteur non démarré.");
//            return volume_reservoir;
//        }
//
//    }

    public boolean utiliser(float volumePourTrajet){

        if(demarre ){
            //Math.min() renvoie le plus petit nombre d'une série de 0 ou plusieurs nombres ou NaN si un des arguments n'et pas un nombre ou ne peut être converti en nombre
            float consoEffective = Math.min(volume_reservoir, volumePourTrajet);
            volume_reservoir -= consoEffective;
            volume_total += consoEffective;
            System.out.println("pour le trajet il faut: " + volumePourTrajet + " litres de carburant. Après trajet il restera: " + volume_reservoir + "litres dans le réservoir, et le moteur aura utilisé: " + consoEffective + " litres de carburant.\n");

            if(volume_reservoir <= 0) {
                System.out.println("Panne d'essence.");
                demarre = false;
                volume_reservoir = 0;
                return false;
            }
            return true;

        } else {
            System.out.println("Impossible d'avancer le Moteur n'est pas démarré.");
            return false;
        }
    }

    public void faireLePlein(float volumeCarburant) {

        if (!demarre) {
            volume_reservoir += volumeCarburant;
            volume_total += volumeCarburant;
            System.out.println("Je fait le plein et ajouté " + volumeCarburant + " litres de carburant.");
        } else {
            System.out.println("le moteur doit être éteint pour faire le plein");
        }
    }

    public void arreter() {
        //est ce que le moteur tourne, si oui on peut arrêter sinon déjà à l'arrêt
        if (demarre) {
            demarre = false;
            System.out.println("J'arrête le moteur.");
        } else {
            System.out.println("Le moteur est déjà arrêté.");
        }
    }
}
