package org.example.filtre_servlet.utils;

public class MessageUtils {

    public static String getSuccessMessage(Boolean successCreated, Boolean successUpdated, Boolean successDeleted) {
        StringBuilder sb = new StringBuilder();

        if (successCreated != null && successCreated) {
            sb.append("<h3>Produit créé avec succès</h3>");
        }

        if (successUpdated != null && successUpdated) {
            sb.append("<h3>Produit mis à jour avec succès</h3>");
        }

        if (successDeleted != null && successDeleted) {
            sb.append("<h3>Produit supprimé avec succès</h3>");
        }

        return sb.toString();
    }
}
