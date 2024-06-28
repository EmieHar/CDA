package org.example;

public class Main {
    public static void main(String[] args) {
        Jeu maMain = new Jeu(10);

        maMain.piocher(new Terrain('b'));
        maMain.piocher(new Creatures("Golem",4 , 6, 6));
        maMain.piocher(new Sortilege("Croissance Gigantesque","La créature ciblée gagne +3/+3 jusqu'à la fin du tour" ,1
                ));

        System.out.println("Là, j'ai en stock :");
        maMain.afficher();
        maMain.joue();
    }

    static class Couleur {
        private char valeur;

        public Couleur(char c) {
            valeur = c;
        }

        public void afficher() {
            this.afficher(false);
        }

        public void afficher(boolean feminin) {
            switch (valeur) {
                case 'r':
                    System.out.println("rouge");
                    break;
                case 'v':
                    System.out.print("vert");
                    if (feminin) {
                        System.out.println("e");
                    }
                    break;
                case 'b':
                    System.out.print("bleu");
                    if (feminin) {
                        System.out.println("e");
                    }
                    break;
                case 'B':
                    System.out.print("blanc");
                    if (feminin) {
                        System.out.println("he");
                    }
                    break;
                case 'n':
                    System.out.print("noir");
                    if (feminin) {
                        System.out.println("e");
                    }
                    break;
            }
        }
    }

    abstract static class Carte{
        private int cout;

        public Carte(){
            cout = 0;
        }

        public Carte(int cout) {
            this.cout = cout;
        }

        public int getCout() {
            return cout;
        }

        public void setCout(int cout) {
            this.cout = cout;
        }

        public String getType(){
            String type = "Type";
            return type;
        }

        public void afficher(){ }
    }

    static class Terrain extends Carte{

        private Couleur couleur;

        public Terrain(char c) {
            couleur = new Couleur(c);
            System.out.println("Un nouveau terrain");

        }

        public void afficher(){
            System.out.println("Un terrain");
            couleur.afficher();
            System.out.println();
        }
    }


    static class Creatures extends Carte{
        private String nom;
        private int points_degats;
        private int points_vie;

        public Creatures(String nom, int points_degats, int points_vie, int cout) {
            super(cout);
            this.nom = nom;
            this.points_degats = points_degats;
            this.points_vie = points_vie;
            System.out.println("Une nouvelle créature");
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public int getPoints_degats() {
            return points_degats;
        }

        public void setPoints_degats(int points_degats) {
            this.points_degats = points_degats;
        }

        public int getPoints_vie() {
            return points_vie;
        }

        public void setPoints_vie(int points_vie) {
            this.points_vie = points_vie;
        }

        public void afficher(){
            System.out.println("Une créature " + nom + " " + points_degats + "/ " + points_vie);
        }

    }

    static class Sortilege extends Carte{
        private String nom;
        private String description;

        public Sortilege(String nom, String description, int cout) {
            super(cout);
            this.nom = nom;
            this.description = description;
            System.out.println("Un sortilège de plus");
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void afficher(){
            System.out.println("Un sortilège " + nom);
        }
    }

    static class Jeu {
        private int nombreCartes;
        private Carte[] cartes;

        public Jeu(int nb) {
            nombreCartes = nb;
            cartes = new Carte[nb];
            System.out.println("On change de main");
        }


        public void joue() {
            System.out.println("Je joue une carte...");
            int i = 0;
            while ((cartes[i] == null) && i < nombreCartes) {
                i++;
            }
            if ((i < nombreCartes) && (cartes[i] != null)) {
                System.out.println("La carte jouée est :");
                cartes[i].afficher();
                cartes[i] = null;
            } else {
                System.out.println("Plus de cartes");
            }
        }

        public void piocher(Carte carte) {
            int i = 0;
            while ((i < nombreCartes) && (cartes[i] != null)) {
                i++;
            }
            if (i < nombreCartes) {
                cartes[i] = carte;
            } else {
                System.out.println("Nombre maximal de cartes atteint");
            }
        }

        public void afficher() {
            for (int i = 0; i < nombreCartes; ++i) {
                if (cartes[i] != null) {
                    cartes[i].afficher();
                }
            }
        }

    }
}