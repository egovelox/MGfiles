// ==========================================================================
// LectureContact : Lecture d'un fichier "contacts" dont le nom est saisi au
//                  clavier
// ==========================================================================

import java.io.*;

public class LectureContact
{
    public static void main(String args[]) throws IOException
    {
        File dossier;
        File fichierEntree;

        FichierContact fc;
        Contact contact;

        dossier = new File("C:\\JAVA\\Fichiers");
        fichierEntree = new File(dossier, "contacts.dat");
        contact = new Contact();

        try
        {
            fc = new FichierContact(fichierEntree, "r");

            try
            {
                System.out.println("Contenu du fichier contacts.dat\n");

                while(true)
                {
                    fc.lire(contact);
                    System.out.println(contact);
                }
            }
            catch(EOFException e)
            {
            }
            finally
            {
                fc.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Le fichier contacts.dat est inconnu.");
        }
    }
}
