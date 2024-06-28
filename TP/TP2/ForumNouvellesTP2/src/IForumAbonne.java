package TP.TP2.ForumNouvellesTP2.src;

import java.util.List;

public interface IForumAbonne {
    boolean ajouterNouvelle(Nouvelle nouvelle);
    Nouvelle consulterNouvelle(int index); // Doit retourner une Nouvelle
    void repondreNouvelle(int index, Nouvelle reponse);
    List<Nouvelle> listerNouvelles(); // Nouvelle méthode pour lister les nouvelles
}
