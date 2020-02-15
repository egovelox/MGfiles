
// ==========================================================================
// Lecture octet par octet d'un fichier texte.
// Affichage en binaire de chacun des caracteres.
// ==========================================================================
import java.io.*;
import utilitairesMG.divers.*;

public class AfficheBytes
{
    public static void main(String args[]) throws IOException
    {
        File dossier;
        File fichierEntree;
        DataInputStream entree;
        int octet;

        String nomFichier;

        System.out.print("Nom du fichier a lire : ");
        nomFichier = Clavier.readString();

        dossier = new File("C:\\JAVA\\fichiers");
        fichierEntree = new File(dossier, nomFichier);

// --------------------------------------------------------------------------   
// Le fichier de texte est ouvert comme s'il s'agissait d'un fichier binaire
// --------------------------------------------------------------------------   
        try
        {
            entree = new DataInputStream(new FileInputStream(fichierEntree));

            try
            {
                while (true)
                {
                    octet = entree.readUnsignedByte();

                    System.out.print((char)octet + "\t");
                    System.out.print(Conversion.intBinaire(octet) + "\t");
                    String hexa = Integer.toHexString(octet).toUpperCase();
                    if (hexa.length() == 1)
                    {
                        hexa = '0' + hexa;
                    }
                    System.out.println(hexa);
                }
            }
            catch (EOFException e)
            {
            }
            finally
            {
                entree.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Le fichier " + nomFichier + " n'existe pas");
        }

        System.out.println("\n");
    }
}
