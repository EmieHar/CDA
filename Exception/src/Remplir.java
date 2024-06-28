package Exception.src;

public class Remplir {

    public Remplir(int quantite) throws LiquideException {
        if(quantite > 10) throw new LiquideException("Trop de liquide, ça va déborder");
    }
}
