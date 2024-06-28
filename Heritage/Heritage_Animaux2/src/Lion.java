package Heritage.Heritage_Animaux2.src;

public class Lion extends Feline{

    public void makeNoise(){
        super.makeNoise();
        System.out.println("Il rugit\r\n");
    }

    public void eat(){
        super.eat();
        System.out.println("De la viande d'antilope\r\n");
    }
}
