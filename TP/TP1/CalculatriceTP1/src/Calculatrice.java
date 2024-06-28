package TP.TP1.CalculatriceTP1.src;

public class Calculatrice {

    public static double calculer(char operateur, double var1, double var2){
        switch (operateur){
            case '+':
                return var1 + var2;
            case '-':
                return var1 - var2;
            case '*':
                return var1 * var2;
            case '/':
                if(var2 != 0){
                    return var1 / var2;
                } else {
                    throw new IllegalArgumentException("la division par zéro est interdite");
                }
            default:
                throw new IllegalArgumentException("opérateur invalide: "+ operateur);

        }
    }
}
