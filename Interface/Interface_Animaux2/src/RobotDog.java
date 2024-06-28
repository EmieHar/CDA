package Interface.Interface_Animaux2.src;

public class RobotDog extends Robot implements Pet {

    @Override
    public void beFriendly() {
        System.out.println("bzitt bzitt, bouge sur ses pates mécaniques");
    }

    @Override
    public void play() {
        System.out.println("tourne sur lui même en lançant la musique de baby Shark");
    }

    public void activate(){
        System.out.println("wouf wouf robotique, roboDog activé\r\n");
    }


}
