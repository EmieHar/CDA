import javax.swing.*;

public class Outils {

    public static void afficher(String titre, Object message) {
        JOptionPane.showMessageDialog(null, message, titre, JOptionPane.INFORMATION_MESSAGE);
    }
}
