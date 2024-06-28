package Bases_Objet;
public class TestVoiture3 {
    public static void main(String[] args){
        Voiture3 v1 = new Voiture3();
       v1.setCouleur("rouge")
        .setMarque("BMW")
        .setCarburant("essence")
        .setAnneeDeFabrication("2000");
       

        v1.presentation();
       

        Voiture3 v2 = new Voiture3("bleue","skoda","essence","2018");
        //v2.presentation(); 
        v2.stop();
        v2.demarrage();
        v2.remplirReservoir();
        v2.demarrage();
        v2.remplirReservoir();


    }
}
