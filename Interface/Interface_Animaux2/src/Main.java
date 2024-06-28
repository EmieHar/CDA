package Interface.Interface_Animaux2.src;

public class Main {
    public static void main(String[] args){
        Hippo hipopo = new Hippo ("hipopo","whoaw", "de la salade", "toujours faim", "dans la marre", "afrique");
        hipopo.presentation();
        hipopo.makeNoise();
        hipopo.roam();

        Lion txipi = new Lion();
        txipi.eat();
        txipi.makeNoise();
        txipi.roam();

        Wolf toto = new Wolf();
        toto.roam();
        toto.eat();
        toto.makeNoise();

        Cat inox = new Cat();
        inox.eat();
        inox.makeNoise();
        inox.roam();
        inox.beFriendly();
        inox.play();

        Dog lassie = new Dog();
        lassie.play();
        lassie.beFriendly();
        lassie.makeNoise();

        Agent tripleX = new Agent();
        tripleX.activate();

        RobotDog rintintin = new RobotDog();
        rintintin.activate();
        rintintin.beFriendly();
        rintintin.play();
    }
}