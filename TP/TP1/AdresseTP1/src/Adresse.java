public class Adresse {
    private int numero_rue;
    private String nom_rue;
    private int codePostal;
    private String ville;

    //constructeur
    public Adresse(int numero_rue, String nom_rue, int codePostal, String ville){
        this.numero_rue = numero_rue;
        this.nom_rue =  nom_rue;
        this.codePostal =codePostal;
        this.ville = ville;
    }

    //getters et setters
    public int getNumeroRue(){
        return numero_rue;
    }
    public void setNumeroRue(int numero_rue ){
        this.numero_rue = numero_rue;
    }

    public String getNomRue(){
        return nom_rue;
    }
    public void setNomRue(String nom_rue ){
        this.nom_rue = nom_rue;
    }

    public int getCodePostal(){
        return codePostal;
    }
    public void setCodePostal(int codePostal){
        this.codePostal = codePostal;
    }

    public String getVille(){
        return ville;
    }
    public void setVille(String ville){
        this.ville = ville;
    }

    //méthode
    public String toString() {
        return numero_rue + ", " + nom_rue + ", " + codePostal + ", " + ville;
    }
}
