// ==========================================================================
// CopieTexte2 : classes BufferedReader et PrintWriter
// --------------------------------------------------------------------------
// Recopie d'un fichier. Lecture en CP1252, ecriture en ISO-8859-1.
// ==========================================================================

import java.io.*;

public class CopieTexte2
{
    public static void main(String args[]) throws IOException
    {
        File dossier;
        File fichierEntree;
        File fichierSortie;
        BufferedReader entree;
        PrintWriter sortie;
        String chaine;

        dossier = new File("C:\\JAVA\\fichiers");
        fichierEntree = new File(dossier, "texteCP1252.txt");
        fichierSortie = new File(dossier, "texteUTF16.txt");

        try
        {
            entree = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(fichierEntree), "Cp1252"));
            try
            {
                sortie = new PrintWriter(fichierSortie, "UTF-16");
                try
                {
                    chaine = entree.readLine();

                    while (chaine != null)
                    {
                        sortie.println(chaine);
                        chaine = entree.readLine();
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
