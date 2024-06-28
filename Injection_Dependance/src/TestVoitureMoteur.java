package Injection_Dependance.src;

public class TestVoitureMoteur {
    public static void main(String[] args){
        Moteur moteur = new Moteur(2.4f,4);
        VoitureMoteur v1 = new VoitureMoteur ("bleue","Volovo", "essence","2010", moteur);
        v1.presentation();
    }
}
