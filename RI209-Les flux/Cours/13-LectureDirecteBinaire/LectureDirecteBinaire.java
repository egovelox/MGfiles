// ==========================================================================
// LectureDirecteBinaire : acces direct au fichier binaire cree par FBinaire1
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class LectureDirecteBinaire
{
    public static void main(String args[]) throws IOException
    {
        File dossier;
        File fichierEntree;
        RandomAccessFile entree;
        int numeroEnreg;
        boolean finSaisie = false;
        int n;

// --------------------------------------------------------------------------
// Ouverture du fichier en lecture ("r")
// --------------------------------------------------------------------------
        dossier = new File("C:\\JAVA\\Fichiers");
        fichierEntree = new File(dossier, "fichier.dat");

        try
        {
            entree = new RandomAccessFile(fichierEntree, "r");

// --------------------------------------------------------------------------
// Boucle de saisie du numero d'enregistrement a lire
// --------------------------------------------------------------------------
            try
            {
                System.out.print(
                    "Entrer le numero de l'enregistrement a lire : ");
                numeroEnreg = Clavier.readInt();

                do
                {
                    try
                    {
                        entree.seek(4 * numeroEnreg);
                        n = entree.readInt();
                        System.out.println("L'enregistrement numero " 
                            + numeroEnreg
                            + " contient la valeur " + n + ".\n");
                        finSaisie = true;
                    }
                    catch (EOFException e)
                    {
                        System.out.print(numeroEnreg
                            + " depasse le dernier indice du fichier ("
                            + ((entree.length() / 4) - 1) + "). ");
                        System.out.print("Entrer un autre numero : ");
                        numeroEnreg = Clavier.readInt();
                    }
                    catch (IOException e)
                    {
                        System.out.print("Le numero saisi ("
                            + numeroEnreg + ") est incorrect. ");
                        System.out.print("Entrer un autre numero : ");
                        numeroEnreg = Clavier.readInt();
                    }
                }
                while (!finSaisie);
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
