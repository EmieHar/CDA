package TP.TP2.ForumNouvellesTP2.src;

import java.util.List;

public interface IForumModerateur {
    boolean supprimerNouvelle(Nouvelle nouvelle);
    void bannirAbonne(Abonne abonne);
    int ajouterAbonne(Abonne abonne);
    List<Nouvelle> listerNouvelles();
    List<Abonne> listerAbonnes();
}
