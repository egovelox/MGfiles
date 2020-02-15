// ==========================================================================
// CopieTexte1 : classes InputStreamReader et OutPutStreamWriter
// --------------------------------------------------------------------------
// Recopie d'un fichier. Lecture en CP1252, ecriture en UTF-8.
// --------------------------------------------------------------------------
// Les classes InputStreamReader et OutPutStreamWriter permettent de lire et
// d'ecrire des fichiers textes en choisissant le codage a utiliser.
// ==========================================================================

import java.io.*;

public class CopieTexte1
{
    public static void main(String args[]) throws IOException
    {
        File dossier;
        File fichierEntree;
        File fichierSortie;
        InputStreamReader entree;
        OutputStreamWriter sortie;
        int caractere;

        dossier = new File("C:\\JAVA\\fichiers");
        fichierEntree = new File(dossier, "texteCP1252.txt");
        fichierSortie = new File(dossier, "texteUTF8.txt");
        
        try
        {
            entree = new InputStreamReader(
                new FileInputStream(fichierEntree), "Cp1252");
            try
            {
                sortie = new OutputStreamWriter(
                    new FileOutputStream(fichierSortie), "UTF-8");
                try
                {
                    caractere = entree.read();

                    while (caractere != -1)
                    {
                        sortie.write(caractere);
                        caractere = entree.read();
                    }
                }
                finally
                {
                    sortie.close();
                }
            }
            finally
            {
                entree.close();
            }

            System.out.println("Copie du fichier effectuée.");
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
