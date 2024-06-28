
public class Voilier extends Bateau{

    public Voilier(){
        System.out.printf("Voilier " + super.bateau());
    }

    public int nbCordes(){
        int i = 8;
        return i;
    }
}
