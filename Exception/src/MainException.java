package Exception.src;

import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import  java.io.FileNotFoundException;

public class MainException {
    public static void main(String[] args) {

//        int monTableau[]  = {1,2,3,4};
//
//        try {

//            monTableau[4] = 5;

//        } catch(Exception e) {
//            System.out.println("erreur d'index");
//        }

        //------ test création exception -----------------------

//        try {
//            Remplir citerne = new Remplir(12);
//        } catch (LiquideException e) {
//            System.out.println(e);
//        }

        //----- autre test exception (division par 0) -----------

//        int x =5;
//        int y =0;
//        try{
//            System.out.println(x/y);
//        } catch(ArithmeticException ae){
//            System.out.printf(ae + " c'est pas bien");
//        }

        //---------- test Scanner pour entrer données -----------

//        int number;
//
//        while (true) {
//            System.out.println("entrez un nombre entier:");
//            try {
//                Scanner scan = new Scanner(System.in);
//                number = Integer.parseInt(scan.next());
//                System.out.println("entrée: " + number);
//                break;
//            } catch(NumberFormatException numFormExc){
//                System.out.println("le nombre entré n'est pas un entier");
//            }
//        }

        //---------- test 2 Scanner pour entrer données -----------

//        float numberFloat;
//
//        while (true) {
//            System.out.println("entrez un nombre:");
//            try {
//                Scanner scan = new Scanner(System.in);
//                numberFloat = Float.parseFloat(scan.next());
//                System.out.println("entrée: " + numberFloat);
//                break;
//            } catch(NumberFormatException numFormExc){
//                System.out.println("le nombre entré n'est pas un entier");
//            }
//        }


        //------------ Lire un fichier -------------------------------

        File monFichier = new File("C:/Users/Emili/OneDrive/Bureau/CDA/JAVA/Classe_Objet/Exception/Bidon");
        try {
            Scanner scan = new Scanner(monFichier);
            while(scan.hasNextLine()){
                String data = scan.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("pas trouvé");
        }

        //----------------- Ecrire dans un fichier ---------------------------

        try{
            //creation  d'un handler (gestionnaire de fichier)
                                                    //ajout bouleen true permet d'ajouter (append) dans un fichier existant au lieu de réécrire le fichier
                                                    // si chemin indique nouveau fichier n'existant pas, le fichier sera créé
            FileWriter monFichier2 = new FileWriter("C:/Users/Emili/OneDrive/Bureau/CDA/JAVA/Classe_Objet/Exception/Bidon2", true);
            monFichier2.write("du texte dans fichier2");
            monFichier2.close();

        } catch(IOException io ){
            System.out.println("err ecriture");
        }
    }
}
