// ==========================================================================
// CreationBinaire : creation d'un fichier binaire
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class CreationBinaire
{
    public static void main(String args[]) throws IOException
    {
        File dossier;
        File fichierSortie;

        DataOutputStream sortie;
        int n;

// --------------------------------------------------------------------------
// Ouverture du flux de sortie
// --------------------------------------------------------------------------
        dossier = new File("C:\\JAVA\\Fichiers");
        fichierSortie = new File(dossier, "fichier.dat");

        try
        {
            sortie = new DataOutputStream(new FileOutputStream(fichierSortie));

            try
            {
                System.out.print("Entrer un entier : ");
                n = Clavier.readInt();

                while (true)
                {
                    sortie.writeInt(n);
                    System.out.print("Entrer un entier : ");
                    n = Clavier.readInt();
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("\nFin de la saisie du fichier d'entiers");
            }
            finally
            {
                sortie.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
