
public class Port {

    private String nom_port;

    public Port(String nomPort){
        this.nom_port = nomPort;
    }

    public String getPort(){
        return this.nom_port;
    }

    public void accueilVaisseau(Amarrable v){
      System.out.println("Il faut "+ v.nbCordes() + " cordes");

    }
}
