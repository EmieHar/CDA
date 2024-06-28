import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //avantage liste est que contrairement à tableau, pas besoin de dimensionner à la déclaration
        List maListe = new ArrayList();

        //ajout éléméent à la liste avec .add()
        maListe.add(2);
        maListe.add("chaîne");
        System.out.println(maListe + "\n");

        //pour tout enlever .clear()
        //pour taille liste .size()

        //opérateur diamand oblige type String
        ArrayList<String> autreListe = new ArrayList<String>();
        autreListe.add("un");
        autreListe.add("deux");
        autreListe.add("trois");

        for (int i = 0; i < autreListe.size(); i++) {
            System.out.println(autreListe.get(i));
        }

        //LinkedList plus rapide mais même principe que listes

        //HashMap notion de clé/valeur, HashSet = éléments unique dans la liste


    }
}