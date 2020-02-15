// =======================================================================
// APPLICATION Exemple4
// -----------------------------------------------------------------------
// Utilisation de DenominateurNulException
// =======================================================================

import utilitairesMG.divers.*;
import java.io.*;

public class Exemple4
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
                System.out.println("Sa partie entiere est : " + 
                    f.partieEntiere());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Denominateur incorrect !");
            }
            catch (DenominateurNulException e)
            {
                System.out.println(e.getMessage());
                System.out.println("La fraction ne peut être instanciée !");
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Numerateur incorrect !");
        }
    }
}
