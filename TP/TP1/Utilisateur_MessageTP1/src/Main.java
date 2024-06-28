import types.CategorieUtilisateur;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Utilisateur jean = new Utilisateur("Jean", "Dupont", CategorieUtilisateur.STANDARD);
        Utilisateur bernard = new Utilisateur("Bernard", "Morin", CategorieUtilisateur.STANDARD);
        Utilisateur nathalie = new Utilisateur("Nathalie", "Morin", CategorieUtilisateur.MODERATEUR);

        System.out.println(jean.toString());
        System.out.println(bernard.toString());
        System.out.println(nathalie.toString());

        JOptionPane.showMessageDialog(null, jean, "Jean", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, bernard, "Bernard", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, nathalie, "Nathalie", JOptionPane.INFORMATION_MESSAGE);

        Message message1 = new Message("Java SE", "L'encapsulation est une propriété fondamentale",
                jean);
        JOptionPane.showMessageDialog(null, message1, "message1", JOptionPane.INFORMATION_MESSAGE);

        Forum forum = Message.forum;
        System.out.println(forum.getListeMessagesAuteur());


    }
}