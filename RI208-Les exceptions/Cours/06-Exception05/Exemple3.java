// =======================================================================
// APPLICATION Exemple3
// ----------------------------------------------------------------------- 
// Appel d'une methode qui peut provoquer une ArithmeticException.
// Traitement de cette erreur.
// =======================================================================

import utilitairesMG.divers.*;
import java.io.*;

public class Exemple3
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
                System.out.println("La partie entiere est : " + 
                    f.partieEntiere());
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
        finally
        {
            System.out.println("Fin du programme...");
        }
    }
}
