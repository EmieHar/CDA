import java.util.ArrayList;
import java.util.List;

public class Port {

    private String nom_port;
    private int capaciteMax;
    private int cordesUtilisees;
    private List<Amarrable> vaisseauxAccueillis;

    public Port(String nomPort, int capaciteMax) {
        this.nom_port = nomPort;
        this.capaciteMax = capaciteMax;
        this.cordesUtilisees = 0;
        this.vaisseauxAccueillis = new ArrayList<>();
    }

    public String getPort(){
        return nom_port;
    }


    public void accueilVaisseau(Amarrable v) {
        int cordeDispo = capaciteMax - cordesUtilisees;
        if (cordesUtilisees + v.nbCordes() <= capaciteMax) {
            System.out.println("Le vaisseau a été accueilli au port.");
            System.out.println("il reste " + cordeDispo + " cordes disponibles.");
            vaisseauxAccueillis.add(v);
            cordesUtilisees += v.nbCordes();
        } else {
            System.out.println("Il faut " + v.nbCordes() + " cordes pour vous accueillir en toute sécurité, il ne reste que " + cordeDispo + " cordes de disponibles.");
        }
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public int getCordesUtilisees() {
        return cordesUtilisees;
    }
}


