// ==========================================================================
// ClientSimple : Test de connexion a un serveur de type ServerSocket
// --------------------------------------------------------------------------
// Le serveur correspondant est ServeurSimple
// --------------------------------------------------------------------------
// Ce programme ouvre la connexion, lit le message de bienvenue du serveur,
// envoie un message, et se ferme...
// ==========================================================================

import java.net.*;
import java.io.*;

public class ClientSimple
{
    public static void main(String argv[])
    {
        Socket socketClient;
        BufferedReader entree;
        PrintWriter sortie;
        String ligne;

        try
        {
            socketClient = new Socket("localhost", 8189);
            try
            {
                sortie = new PrintWriter(
                    new OutputStreamWriter(
                        socketClient.getOutputStream(), "UTF-8"));

                entree = new BufferedReader(
                    new InputStreamReader(
                        socketClient.getInputStream(), "UTF-8"));

// --------------------------------------------------------------------------
// Lecture du message d'accueil
// --------------------------------------------------------------------------
                //System.out.println("\n");
                ligne = entree.readLine();
                System.out.println(ligne);

// --------------------------------------------------------------------------
// Envoi d'un message au serveur
// --------------------------------------------------------------------------
                sortie.println("Compr€nds-tu les éùï, ami serveur ?");
                sortie.flush();
            }
            finally
            {
                socketClient.close();
            }
        }
        catch (IOException e)
        {
            System.out.println("Le serveur ne répond pas !");
        }
    }
}
