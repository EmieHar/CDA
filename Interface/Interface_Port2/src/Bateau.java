
public abstract class Bateau implements Amarrable {

    public int masse;

    public String bateau(){
        return "mis à l'eau\n";
    }

    public abstract int nbCordes();
}
