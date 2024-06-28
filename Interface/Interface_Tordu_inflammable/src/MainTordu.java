package Interface.Interface_Tordu_inflammable.src;

public class MainTordu {

    public static void main(String[] args){

        Inflammable[] monTab = { new Bois(), new Dancefloor(), new Neurones(), new Slip()};

        for(Inflammable i: monTab){
            i.enflammer();
        }
    }
}
