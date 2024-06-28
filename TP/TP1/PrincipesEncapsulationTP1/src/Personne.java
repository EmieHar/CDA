package TP.TP1.PrincipesEncapsulationTP1.src;

public class Personne {
    private String nom;
    private String societe;
    private static final String PAS_DE_SOCIETE = "?";

    //constructeur
    public Personne(String nom){
        this.nom = nom.toUpperCase();
        this.societe = PAS_DE_SOCIETE;
    }
    public Personne(String nom, String societe){
        this.nom = nom.toUpperCase();
        this.societe = validerSociete(societe).toUpperCase();
    }

    //accesseurs / mutateurs
    public void setNom(String nom){
        this.nom = nom.toUpperCase();
    }

    public String getNom(){
        return nom;
    }

    public void setSociete(String societe){
        if(!this.societe.equals(PAS_DE_SOCIETE)){
            System.out.println("Erreur:\n 1- quitterSociete, puis\n 2- affecterSociete ");
            return;
        }
        this.societe = validerSociete(societe).toUpperCase();
    }

    public String getSociete(){
        return societe;
    }

    //méthodes
    public void afficher() {
        System.out.println("Je m'appelle " + nom);
        if (!societe.equals(PAS_DE_SOCIETE)) {
            System.out.println("je travaille chez: " + societe);
        } else {
            System.out.println(" je ne suis pas employé d'une entreprise");
        }
    }

    public void quitterSociete() {
        if (societe.equals(PAS_DE_SOCIETE)) {
            afficher();
            System.out.println("Je ne suis pas salarié, impossible de quitter la société.");
            // Arbitrairement quitter le programme, code erreur 1
            System.exit(1);
        } else {
            System.out.println("La personne " + nom + " a quitté sa société ( " + societe + " ).");
            societe = PAS_DE_SOCIETE;
        }
    }

    //méthode filtre
    private String validerSociete(String societe){

        if( societe.length() > 30 ){
            System.out.println("Erreur: La longueur du nom de la société dépasse 30 caractères.");
            System.out.println("Java result: 1");
            System.exit(1);
        } else if(societe.equals(PAS_DE_SOCIETE ) ){
            System.out.println("Classe Personne, societé incorrecte: " + societe);
            System.out.println("Java result: 2");
            System.exit(2);

        }

        return societe;

    }

}
