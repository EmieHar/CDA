
public class Main {

    public static void main(String[] args){
        Voilier v1 = new Voilier();
        v1.masse = 400;

        Paquebot p1 = new Paquebot();
        Paquebot p2 = new Paquebot();
        p1.masse = 1000;

        BateauDePeche bp1 = new BateauDePeche();

        SousMarin s1 = new SousMarin();
        s1.masse= 800;

        Port brest = new Port("BREST", 50);
        
        brest.accueilVaisseau(v1);
        brest.accueilVaisseau(p1);
        brest.accueilVaisseau(p2);
        brest.accueilVaisseau(bp1);
        brest.accueilVaisseau(s1);
    }
}
