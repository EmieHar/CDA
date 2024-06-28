

public class Main {

    public static void main(String[] args){
        Bateau b1 = new Bateau();
        b1.masse = 400;

        SousMarin s1 = new SousMarin();
        s1.masse= 800;

        Port brest = new Port("BREST");

        brest.accueilVaisseau(b1);
        brest.accueilVaisseau(s1);
    }
}
