package util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    // Hasher le mot de passe
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Vérifier si le mot de passe correspond au hachage stocké
    public static boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}