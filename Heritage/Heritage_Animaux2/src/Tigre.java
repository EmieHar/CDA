package Heritage.Heritage_Animaux2.src;

public class Tigre extends Feline{

    public void makeNoise(){
        super.makeNoise();
        System.out.println("Il rugit et feule\r\n");
    }

    public void eat(){
        super.eat();
        System.out.println("Du gibier, des oideaus ou du poisson\r\n");
    }
}
