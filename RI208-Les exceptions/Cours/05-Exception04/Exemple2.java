// ==========================================================================
// APPLICATION Exemple2
// --------------------------------------------------------------------------
// Traitement separe de la saisie du numerateur et du denominateur
// ==========================================================================

import utilitairesMG.divers.*;
import java.io.*;

public class Exemple2
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
            try
            {
                System.out.print("Entrez le denominateur : ");
                den = Clavier.readInt();

                f = new Fraction(num, den);
                System.out.println(
                    "Bravo ! La fraction " + f + " est instanciee !");
            }
            catch (NumberFormatException e)
            {
                System.out.println("Denominateur incorrect !");
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Numerateur incorrect !");
        }
    }
}
