// ==========================================================================
// TestFile : class File
// ==========================================================================

import java.io.*;

public class TestFile
{
    public static void main(String args[]) throws IOException
    {
        File dossier;
        File fichier1, fichier2;

        dossier = new File("C:\\JAVA\\Fichiers");
        System.out.println(dossier.getAbsolutePath());

        fichier1 = new File(dossier, "texteOriginal.txt");
        System.out.println(fichier1.getAbsolutePath());

        fichier2 = new File("C:\\JAVA\\Fichiers\\texteOriginal.txt");
        System.out.println(fichier2.getAbsolutePath());

        System.out.println("Taille du fichier " + 
                           fichier2.getName() + " : " + 
                           fichier2.length() + " octets");
    }
}
