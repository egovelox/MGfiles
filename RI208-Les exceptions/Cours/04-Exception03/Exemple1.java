// ==========================================================================
// APPLICATION Exemple1
// ==========================================================================

import utilitairesMG.divers.*;
import java.io.*;

public class Exemple1
{
    public static void main(String argv[]) throws IOException
    {
        Fraction f;
        int num;
        int den;

        try
        {
            System.out.print("Entrez le numerateur : ");
            num = Clavier.readInt();
            System.out.print("Entrez le denominateur : ");
            den = Clavier.readInt();
            f = new Fraction(num, den);
            System.out.println(
                "Bravo ! La fraction " + f + " est instanciee !");
        }
        catch (NumberFormatException e)
        {
            System.out.println("Entier incorrect !");
        }
    }
}
