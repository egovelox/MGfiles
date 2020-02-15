// ==========================================================================
// ClientEcho : client des serveurs ServeurMono et ServeurMulti
// --------------------------------------------------------------------------
// Les serveurs ServeurMono et ServeurMulti renvoient l'echo des messages
// envoyes par le client (par l'intermediaire de ce programme par exemple,
// mais aussi par Telnet...).
// --------------------------------------------------------------------------
// Ce programme ouvre la connexion, lit le message de bienvenue du serveur,
// envoie des messages et lit les reponses du serveur. Lorsque le message
// renvoye par le serveur est "FIN", le programme se termine...
// ==========================================================================

import java.net.*;
import java.io.*;
import utilitairesMG.divers.*;

public class ClientEcho
{
    public static void main(String argv[]) throws ClassNotFoundException
    {

// --------------------------------------------------------------------------
// socketClient : reference d'une socket vers le serveur
// sortie        : flux vers le serveur
// entree        : flux en provenance du serveur
// --------------------------------------------------------------------------
        Socket socketClient;
        ObjectOutputStream sortie;
        ObjectInputStream entree;

        String ligne;

        try
        {

// --------------------------------------------------------------------------
// L'instanciation de l'objet Socket ouvre la connexion avec le serveur. Si
// le serveur est indisponible, il y a lancement d'une ConnectException.
// --------------------------------------------------------------------------
// Le setSoTimeout(1000) permet de declencher une erreur de type
// SocketTimeoutException sur le premier readObject(), qui doit lire le
// message d'accueil du serveur. Cette situation se produit quand le
// readObject est impossible, par exemple quand un autre client est connecte
// au ServeurMono ou que le ServeurMulti a recu l'ordre de s'arreter alors
// que certains clients travaillent encore...
// --------------------------------------------------------------------------
            socketClient = new Socket("localhost", 8189);
            try
            {
                socketClient.setSoTimeout(1000);

                entree = new ObjectInputStream(socketClient.getInputStream());
                sortie = new ObjectOutputStream(socketClient.getOutputStream());

// --------------------------------------------------------------------------
// Lecture du message d'accueil
// --------------------------------------------------------------------------
                ligne = (String) entree.readObject();
                System.out.print(ligne);

// --------------------------------------------------------------------------
// Boucle d'envoi de messages au serveur. Cette boucle s'arrete quand le
// serveur envoie le message "FIN".
// --------------------------------------------------------------------------
                ligne = Clavier.readString();
                sortie.writeObject(ligne);

                while (ligne.compareTo("")!= 0)
                {
                    ligne = (String) entree.readObject();
                    System.out.print(ligne);
                    ligne = Clavier.readString();
                    sortie.writeObject(ligne);
                }
                ligne = (String) entree.readObject();
                System.out.println(ligne);
            }
            finally
            {
                socketClient.close();
            }
        }
        catch (ConnectException e)
        {
            System.out.println("Connexion impossible : serveur indisponible");
        }
        catch (SocketTimeoutException e)
        {
            System.out.println("Connexion impossible");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
