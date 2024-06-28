import types.CategorieUtilisateur;

public class MessageUtilisateur {
    private Utilisateur utilisateur;
    private Message message;

    public MessageUtilisateur(Utilisateur utilisateur, Message message) {
        this.utilisateur = utilisateur;
        this.message = message;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Message getMessage() {
        return message;
    }
}
