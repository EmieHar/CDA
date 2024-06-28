package Heritage.Heritage_Animaux2.src;

public class Wolf extends Canine{

    public void makeNoise(){
        super.makeNoise();
        System.out.println("Il hurle\r\n");
    }

    public void eat(){
        super.eat();
        System.out.println("Du lièvre, des reptiles, du gibier ou des batraciens\r\n");
    }
}
