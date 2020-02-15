// ==========================================================================
// APPLICATION TestControleInt :
// --------------------------------------------------------------------------
// Création d'une classe d'Exception personnelle
// ==========================================================================

import java.io.*;

public class TestControleInt
{
    public static void main(String argv[]) throws IOException
    {
        int i;
        i = ControleInt.saisieInt(150, 200);
        System.out.println("Valeur saisie : " + i);
    }
}