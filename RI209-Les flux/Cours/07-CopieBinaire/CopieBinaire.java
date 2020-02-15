
import java.io.*;

public class CopieBinaire
{
    public static void main(String args[]) throws IOException
    {
        File dossier;
        File fichierEntree;
        File fichierSortie;

        FileInputStream entree;
        FileOutputStream sortie;
        
        int octet;

        dossier = new File("C:\\JAVA\\fichiers");
        fichierEntree = new File(dossier, "texteOriginal.txt");
        fichierSortie = new File(dossier, "texteCopieBinaire.txt");
        
        entree = new FileInputStream(fichierEntree);
        try
        {
            sortie = new FileOutputStream(fichierSortie);
            try
            {
                octet = entree.read();
                while (octet != -1)
                {
                    sortie.write(octet);
                    octet = entree.read();
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
    }
}
