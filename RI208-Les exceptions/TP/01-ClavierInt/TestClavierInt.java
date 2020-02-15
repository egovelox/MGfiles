// ==========================================================================
// APPLICATION TestClavierInt :
// --------------------------------------------------------------------------
// Création d'une classe d'Exception personnelle
// ==========================================================================

import java.io.*;

public class TestClavierInt
{
    public static void main(String argv[]) throws IOException
    {
        int i;
        try
        {
            System.out.print("Saisir un entier : ");
            i = ClavierInt.readInt(150, 200);
            System.out.println("Valeur saisie : " + i);
        }
        catch (NumberFormatException | BorneException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
