package Base_Primitive;

// le nom du fichier doit avoir le même nom que la fonction main
public class BasesPrimitives{

    // void signifie vide pour les fonctions qui ne renvoient rien
    public static void main(String[] args) {
        // fonction permettant d'imprimer 1 chaîne de caractères (pour chaîne concaténées autre fonction: printf)
        System.out.println("Hello World!");

        // les primitives sont en minucule ce sont le formats de data 
        int x =10; //integer 32bits max
        long l = 10; // long entier sur 64bits max
        short s = 16; // entier sur 16 bits max
        byte b = 1; // entier sur 8 bits max

        float f = 0.4f; // jusqu'à 7 chiffres après virgule sur 32bits
        double d= 0.11111111f;// max 15 chiffres après virgule 64bits

        char c = 'a'; //pour chaîne de caractères

        boolean bool = true; // true ou false
        int test = null; // type primitif null 

        //possible de convertir un type en une autre (ici un double en int)
        double myDouble = 9.78d;
        int myInt = (int) myDouble;
        //cast en type entier
        int entier =Integer.parseInt("15");
        //cast en type float
        Float z = Float.parseFloat("25.7");

        //possible de concaténer les chaînes de caractère avec + ou c1.concat(c2)

        //récupérer l'index de la première occurence de "e" dans une chaîne de caractère
        String txt = "Hello Everybody";
        System.out.println(txt.indexOf("e"));

        //racine carrée
        int rc = 16;
        Math.sqrt(rc);

        // String est une classe mais peut être utilisée directement
        String nom = "John";
        String nom2 = "John";

        if (nom == nom2) {
            System.out.println("ok");
        }

        if (nom.equals(nom2)) {
            System.out.println("ok cool");
        }

        // \n est le retour chariot
        System.out.printf("La valeur de x est: %d %n et le nom est %s \n", x, nom);

        /*format déclaration pour printf: 
         %c character
         %C character force uppercase
         %d decimal (integer) number base 10
         %e exponentiel floating-point number
         %f floating-point number
         %i integer bas10
         %h hashcode (idéal adresse)
         %o octal number base8
         %s String
         %S String force uppercase
         %u unsigned decimal (integer) number
         %x number in hexadecimal base 16
         %t formats date/time*%% print a percent sign
         /% print a percent sign
         %n newline character, platforme specific (retour chariot)
        
         pour la date: The t time/date character is followed by one of the following characters to extract parts of a datetime value:

                T: Time in hh:mm:ss format.
                H: Hour.
                M: Minute.
                S: Second.
                L: Millisecond.
                N: Nanosecond.
                p: A.M./P.M.
                z: Time zone offset.
                A: Full day of the week.
                d: Two digit day of the month.
                B: Full month name.
                m: Two-digit month.
                Y: Four-digit year.
                y: Last two digits of year.
        */ 

    int day = 3;
        switch(day){
            case 1:
            System.out.println("Monday");
            break;
            case 2:
            System.out.println("Tuesday");
            break;
            case 3:
            System.out.println("Wenesday");
            break;
            case 4:
            System.out.println("Thursday");
            break;
            case 5:
            System.out.println("Friday");
            break;
            case 6:
            System.out.println("Saturday");
            break;
            case 7:
            System.out.println("Sunday");
            break;
        }

        int i = 0;
        while (i< 10){
            System.out.println(i);
            i++; //incrémentation
        }

        for (int j =0; j<10; j++) {
            System.out.println(j);
        }

        //tableau de chaîne de caractères 
        String Cars[] = {"volvo", "renault", "skoda", "citroen"};

        for(String cars : Cars) {
            System.err.println(cars);
        }
    }
}