import java.util.Date;
import java.text.DateFormat;

public class Message {
    private String titre;
    private String texte;
    private Date dateCreation;
    private Utilisateur utilisateur;
    public static final Forum forum = new Forum();

    //constructeur
    public Message(String titre, String texte, Utilisateur utilisateur) {
        this.titre = titre;
        this.texte = texte;
        this.utilisateur = utilisateur;
        this.dateCreation = new Date();
        forum.ajouterUtilisateurMessages(utilisateur, this);
    }

    //getters et setters
    public String getTitre(){
        return titre;
    }
    public void settitre(String titre){
        this.titre=titre;
    }

    public String getTexte(){
        return texte;
    }
    public void setTexte(String texte){
        this.texte = texte;
    }

    public String getDateCreation() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
        return df.format(dateCreation);
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    //méthode
    public String toString() {
        return titre + " -- " + texte + "\nDate de création : " + getDateCreation() + "\n" +
                utilisateur ;
    }

    public String getAuteur() {
        return utilisateur.getPrenom() + " " + utilisateur.getNom() + ", " + utilisateur.getStatut();
    }


}
