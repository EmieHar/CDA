package TP.TP2.ForumNouvellesTP2.src;

import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Création du forum
        String nomForum = JOptionPane.showInputDialog("Entrez le nom du forum:");
        Forum forum = new Forum(nomForum);



        // Création d'un modérateur et d' abonnés
        Moderateur moderateur = new Moderateur("John", "Doe", 35);
        Abonne abonne1 = new Abonne("John", "Doe", 30);
        Abonne abonne2 = new Abonne("Jane", "Smith", 25);
        Abonne abonne3 = new Abonne("Janine", "Smith", 50);

        abonne1.setForum(forum);
        abonne2.setForum(forum);
        abonne3.setForum(forum);
        moderateur.setForum(forum);

    // Ajout des abonnés par le modérateur
        moderateur.ajouterAbonne(abonne1);
        moderateur.ajouterAbonne(abonne2);
        moderateur.ajouterAbonne(abonne3);



        // Ajout d'une nouvelle par l'abonné
         String sujet = JOptionPane.showInputDialog("Le sujet de votre message:");
         String texte = JOptionPane.showInputDialog("Votre message:");
         abonne2.ajouterNouvelle(sujet, texte);

        String sujet2 = JOptionPane.showInputDialog("Le sujet de votre message:");
        String texte2 = JOptionPane.showInputDialog("Votre message:");
        abonne2.ajouterNouvelle(sujet2, texte2);


        // Listing des nouvelles par l'abonné
        List<Nouvelle> nouvelles = abonne2.consulterNouvelles();
        System.out.println("\n Nouvelles dans le forum:");
        for (Nouvelle n : nouvelles) {
            System.out.println(n.getSujet() + " - " + n.getTexte());
        }

        // Bannir un abonné par le modérateur
        moderateur.avertirAbonne(abonne1);
        moderateur.avertirAbonne(abonne1);
        moderateur.avertirAbonne(abonne1);

        // Listing des abonnés par le modérateur

        List<Abonne> abonnesDansForum = moderateur.listerAbonnes();
        System.out.println("\n Abonnés dans le forum:");
        for (Abonne abonne : abonnesDansForum) {
            System.out.println("Abonné: " + abonne.getPrenom() + " " + abonne.getNom() + ", Age: " + abonne.getAge());
        }

        //afficher nom forum:
        System.out.println("\n le nom du forum et sa date de création:");
        System.out.println("nom forum: " + forum.getNom() + " créé le: " + forum.getDateCreation());
    }
}
