public class Forum {
    private static final int NBR_MESSAGES = 100;
    private int nombreMessages;
    private MessageUtilisateur[] messages;

    public Forum() {
        this.messages = new MessageUtilisateur[NBR_MESSAGES];
        this.nombreMessages = 0;
    }

    public boolean ajouterUtilisateurMessages(Utilisateur utilisateur, Message message) {
        if (nombreMessages < NBR_MESSAGES) {
            messages[nombreMessages++] = new MessageUtilisateur(utilisateur, message);
            return true;
        } else {
            System.out.println("Le tableau de messages est plein.");
            return false;
        }
    }

    public String getListeMessagesAuteur() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombreMessages; i++) {
            MessageUtilisateur mu = messages[i];
            sb.append(mu.getMessage().toString()).append("\n");
        }
        return sb.toString();
    }
}