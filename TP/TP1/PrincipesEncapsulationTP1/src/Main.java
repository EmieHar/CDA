package TP.TP1.PrincipesEncapsulationTP1.src;

public class Main {

    public static void main(String[] args) {
        System.out.println("Passage dans main");

        Personne martin = new Personne ( "martin","JavaSARL");
        Personne dupont = new Personne ("dupont") ;
        martin.afficher();
        dupont.afficher();

        Personne durand = new Personne("durand", "J2ESA");
        durand.afficher();
        durand.quitterSociete();
        durand.afficher();

        durand.setSociete("EJB Corporate");
        durand.afficher();
        durand.setSociete("EJB Corporate");
        durand.afficher();

        Personne machin = new Personne("machin", "?");
        machin.afficher();

    }
}