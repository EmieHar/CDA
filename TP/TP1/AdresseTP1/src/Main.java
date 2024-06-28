import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Adresse adresse1 =new Adresse(2,"rue Victor Hugo", 75008, "Paris");
        Adresse adresse2 = new Adresse(17, "rue de la République", 44000, "Nantes");
        Adresse adresse3 = new Adresse(55, "Bld de la Libération", 59000, "Lille");

        System.out.println("adresse de Paris " + adresse1);
        System.out.println("adresse de Nantes " + adresse2);
        System.out.println("adresse de Lille " + adresse3);

        // Affichage des adresses dans des boîtes de dialogue
        JOptionPane.showMessageDialog(null, adresse1, "Adresse de Paris", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, adresse2, "Adresse de Nantes", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, adresse3, "Adresse de Lille", JOptionPane.INFORMATION_MESSAGE);

        Personne jean = new Personne("Dupont", "Jean", 30, adresse3);
        Personne bernard = new Personne("Morin", "Bernard", 45, adresse1);
        Personne nathalie = new Personne("Durand", "Nathalie", 35, adresse2);

        JOptionPane.showMessageDialog(null, jean, "Jean", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, bernard, "Bernard", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, nathalie, "Nathalie", JOptionPane.INFORMATION_MESSAGE);

        // Jean déménage à une nouvelle adresse
        jean.setAdresse(new Adresse(44, "Rue des Docks", 33000, "Bordeaux"));

        javax.swing.JOptionPane.showMessageDialog(null, jean, "Jean après déménagement", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        //nouvelle adresse sans nouvelle instance --> affecter adresse bernard à nathalie
        nathalie.setAdresse(bernard.getAdresse());

        // Affichage dans une boîte de dialogue
        javax.swing.JOptionPane.showMessageDialog(null,  "Nathalie: " + nathalie + "\nBernard: " + bernard , "Vive les mariés!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        Outils.afficher("Après le mariage", "Bernard: " + bernard + "\nNathalie: " + nathalie);

        Outils.afficher("jean",jean);
    }
}