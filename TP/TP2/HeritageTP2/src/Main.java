package HeritageTP2.src;

//pour avoir des boîtes de dialogue
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
//    Moteur moteru = new Moteur();
//
//    moteru.demarrer();
//    moteru.faireLePlein(50);
//    System.out.println("Hello world!");
//
//    moteru.demarrer();
//    moteru.utiliser(30);
//
//    Voiture laguna2 = new Voiture("Renault", "Laguna2", 30.0f);
//    System.out.println(laguna2);
//    laguna2.demarrer();
//        try{
//            laguna2.rouler(25);} catch(PanneEssenceException exc){
//            System.out.println(exc.getMessage());
//        }
//    System.out.println(laguna2);


//    Voiture laguna = new Voiture("Renault", "Laguna", 30.0f);
//    System.out.println(laguna);
//        try {
//            laguna.rouler(35);
//        } catch(PanneEssenceException exc){
//            JOptionPane.showMessageDialog(null, "La laguna vient de tomber en panne : " + exc.getMessage());
//              // ------ valeur arbitraire--------
////            laguna.faireLePlein(50);
////            laguna.demarrer();
////            System.out.println("Réservoir rempli avec 50 litres et voiture redémarrée.");
//
//            //------- boîte de saisie -------
//            String resultat = JOptionPane.showInputDialog(null, "Veuillez saisir le nombre de litres que vous souhaitez ajouter au résevoir");
//
//            // Conversion de la chaîne en entier ->  Integer i = new Integer (resultat ) ; dépassé dupuis JAVA 5
//            int litres = Integer.parseInt(resultat);
//            laguna.faireLePlein(litres);
//            laguna.demarrer();
//            System.out.println("Réservoir rempli avec " + litres + " litres et voiture redémarrée.\n");
//
//        }


//        Voiture c5 = new Voiture("Citroën", "C5", 40.0f);
//        System.out.println(c5);
//
//            for(int i =0; i<6; i++){
//                try {
//                    c5.rouler(10);
//                } catch (PanneEssenceException ex) {
//                    JOptionPane.showMessageDialog(null, "La C5 vient de tomber en panne : " + ex.getMessage());
//
//                    c5.faireLePlein(50);
//                }
//            }
//        System.out.println(c5);
//
//
//        Scooter scoot = new Scooter ("Yamaha", "X-MAX", 20);
//        System.out.println(scoot);
//
//        for(int i=0; i<3;i++){
//            try{
//                scoot.rouler(10);
//            } catch (PanneEssenceException exScoot){
//                JOptionPane.showMessageDialog(null, "La scooter vient de tomber en panne : " + exScoot.getMessage());
//                scoot.faireLePlein(15);
//            }
//            System.out.println(scoot);
//        }


        // Création et contrôle du parc de véhicules
        Voiture v1 = new Voiture("Renault", "Laguna", 30.0f);
        Voiture v2 = new Voiture("Peugeot", "308", 40.0f);
        Voiture v3 = new Voiture("Citroën", "C5", 35.0f);
        Voiture v4 = new Voiture("BMW", "X5", 50.0f);
        Scooter s1 = new Scooter("Yamaha", "X-MAX", 20.0f);
        Scooter s2 = new Scooter("Honda", "PCX", 25.0f);
        Scooter s3 = new Scooter("Piaggio", "Vespa", 2.0f);

        Vehicule[] vehicules = {v1, v2, v3, v4, s1, s2, s3};
        ParcVehicules parc = new ParcVehicules(vehicules);

        parc.controlerVehicules();
    }

}