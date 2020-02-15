// ==========================================================================
// LectureBinaire : lecture du fichier binaire cree par FBinaire1
// ==========================================================================

import java.io.*;

public class LectureBinaire
{
    public static void main(String args[]) throws IOException
    {
        File dossier;
        File fichierEntree;

        DataInputStream entree;
        int n;

// --------------------------------------------------------------------------
// Ouverture du flux d'entree
// --------------------------------------------------------------------------
        dossier = new File("C:\\JAVA\\Fichiers");
        fichierEntree = new File(dossier, "fichier.dat");

        try
        {
            entree = new DataInputStream(new FileInputStream(fichierEntree));

            try
            {
                n = entree.readInt();
                try
                {
                    System.out.println("Liste des entiers de fichier.dat : \n");
                    while (true)
                    {
                        System.out.println(n);
                        n = entree.readInt();
                    }
                }
                catch (EOFException e)
                {
                    System.out.println("\nFin de l'impression...");
                }
            }
            catch (EOFException e)
            {
                System.out.println("Le fichier fichier.dat est vide...");
            }
            finally
            {
                entree.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}