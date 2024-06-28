package org.example;

public class Main {


    private final static int CURRENT_YEAR = 2024;

    public static void main(String[] args) {
        Ustensile[] us = new Ustensile[5];
        us[0] = new AssietteRonde(1926, 8.4);
        us[1] = new Cuillere(1881, 7.3);
        us[2] = new AssietteCarree(1935, 5.6);
        us[3] = new Cuillere(1917, 8.8);
        us[4] = new AssietteRonde(1837, 5.4);

        Collection.afficherCuilleres(us);
        Collection.afficherSurfaceAssiettes(us);
        Collection.afficherValeurTotale(us);
    }

    static class Collection {


        static void afficherValeurTotale(Ustensile[] us) {
            double somme = 0;
            for (int i = 0; i < us.length; i++) {
                somme = somme + us[i].calculerValeur(CURRENT_YEAR);
            }
            System.out.println("Valeur totale de la collection : " + somme);
        }

        static void afficherCuilleres(Ustensile[] us) {
            int nbCuilleres = 0;
            for (int i = 0; i < us.length; i++) {
                if (us[i] instanceof Cuillere) {
                    nbCuilleres++;
                }
            }
            System.out.println("Il y a " + nbCuilleres + " cuillères.");
        }

        static void afficherSurfaceAssiettes(Ustensile[] us) {
            double somme = 0;
            for (int i = 0; i < us.length; i++) {
                if (us[i] instanceof Assiette) {
                    somme = somme + ((Assiette) us[i]).calculerSurface();
                }
            }
            System.out.println("Surface totale des assiettes : " + somme);
        }
    }

   abstract static class Ustensile{
        private int annee_fabrication;

        public Ustensile (int annee_fabrication){
            this.annee_fabrication = annee_fabrication;
        }

       public double calculerValeur(int anneeActuelle) {
           int age = (anneeActuelle - getAnneeFabrication());
           double valeur = 0;
           if (age > 50) {
               valeur = age - 50;
           }
           return valeur;
       }

        public int getAnneeFabrication(){
            return  annee_fabrication;
        }
   }


    static class Cuillere extends Ustensile{
        private double longueur;

        public Cuillere (int annee_fabrication, double longueur){
            super(annee_fabrication);
            this.longueur = longueur;
        }

        public double getLongueur() {
            return longueur;
        }
    }

    abstract static class Assiette extends Ustensile{


        public Assiette (int annee_fabrication){
            super(annee_fabrication);
        }

        public abstract double calculerSurface();
    }

    static class AssietteRonde extends Assiette {
        private double rayon;

        public AssietteRonde(int annee_fabrication, double rayon) {
            super(annee_fabrication);
            this.rayon = rayon;
        }

        public double calculerSurface() {
            return (3.14 * getRayon() * getRayon());
        }

        public double getRayon() {
            return rayon;
        }
    }

    static class AssietteCarree extends Assiette{
        private double cote;

        public AssietteCarree (int annee_fabrication, double cote){
            super(annee_fabrication);
            this.cote  = cote;
        }

        public double calculerSurface() {
            return (getCote() * getCote());
        }

        public double calculerValeur(int anneeActuelle) {
            double valeur = 5 * super.calculerValeur(anneeActuelle);
            return valeur;
        }

        public double getCote() {
            return cote;
        }

    }

}
