// ==========================================================================
// Projet serveurMulti : serveur multiThreads (echo)
// --------------------------------------------------------------------------
// ThreadClient : processus de dialogue avec un client (thread esclave).
// ==========================================================================

import java.net.*;
import java.io.*;

public class ThreadClient extends Thread
{

// --------------------------------------------------------------------------
// Proprietes :
//
// socketServeur : reference d'une socket du serveur vers le client.
//                Cette socket est ouverte par le thread maitre (serveur) et
//                transmise au constructeur.
// --------------------------------------------------------------------------
    private Socket socketServeur;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public ThreadClient(Socket socketServeur)
    {
        this.socketServeur = socketServeur;
    }

// --------------------------------------------------------------------------
// Traitement de chaque client. Cette methode est commune a tous les objets
// de type ThreadClient crees par le thread Serveur. Mais les proprietes et
// les parametres de methodes sont dupliques (on peut le mettre en evidence
// en affichant les references d'entree et sortie ci-dessous). Il n'y a pas
// de probleme de melange de donnees (pas de necessite de synchronisation).
// --------------------------------------------------------------------------
    public void run()
    {
        ObjectInputStream entree;
        ObjectOutputStream sortie;

        String ligne;
        String chaineOiseaux;
        int nombreOiseaux;

        chaineOiseaux = "";
        nombreOiseaux = 0;

// --------------------------------------------------------------------------
// Ouverture des flux.
// --------------------------------------------------------------------------
// REMARQUE IMPORTANTE :
// --------------------------------------------------------------------------
// Il faut mettre le ObjectOutputStream avant le ObjectInputStream. En effet,
// le new ObjectInputStream() attend que le ObjectOutputStream du client soit
// fait. Si par hasard le client ecrit son new ObjectInputStream() avant son
// new ObjectOutputStream(), les deux applications vont se bloquer
// mutuellement !
// --------------------------------------------------------------------------
        try
        {
            try
            {
                sortie = new ObjectOutputStream(socketServeur.getOutputStream());
                entree = new ObjectInputStream(socketServeur.getInputStream());

// --------------------------------------------------------------------------
// Message d'accueil pour le client.
// --------------------------------------------------------------------------
                sortie.writeObject(
                    "Bonjour, entrez des noms d'oiseaux(Entrée pour finir) :\n"
                    + (nombreOiseaux + 1) + " -> ");

                ligne = (String) entree.readObject();
                ligne = ligne.trim();

                while (ligne.compareTo("") != 0)
                {
                    System.out.println("Chaine reçue : " + ligne);
                    if (nombreOiseaux > 0)
                    {
                        chaineOiseaux += ", ";
                    }

                    nombreOiseaux++;
                    chaineOiseaux += ligne;
                    sortie.writeObject((nombreOiseaux + 1) + " -> ");

                    ligne = (String) entree.readObject();
                    ligne = ligne.trim();
                }

                sortie.writeObject("Voici votre liste : " + chaineOiseaux);
            }
            catch(ClassNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
            finally
            {
                socketServeur.close();
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}