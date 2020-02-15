// ==========================================================================
// APPLICATION Exception02 : try...catch, throws
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class Exception02
{
    public static void main(String argv[]) throws IOException
    {
        int nombre;

        System.out.print("Saisir un nombre entier : ");

        try
        {
            nombre = Clavier.readInt();
            System.out.println("\nNombre saisi : " + nombre);
        }
        catch (NumberFormatException e)
        {
            System.out.println("\nNombre incorrect(" + e.getMessage() + ")");
        }
    }
}
