
public class BateauDePeche extends Bateau  {

    public BateauDePeche(){
        System.out.printf("Bateau de pêche " + super.bateau());
    }
    public int nbCordes(){
        int i = 4;
        return i;
    }
}
