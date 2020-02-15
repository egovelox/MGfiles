// ==========================================================================
// ServeurMono : Serveur qui renvoie l'echo de ce que le client envoie
// --------------------------------------------------------------------------
// Pour tester ce programme, utiliser le programme client : ClientEcho.java.
// --------------------------------------------------------------------------
// Ce serveur ne permet que de repondre a un client (Mono client)
// ==========================================================================

import java.net.*;
import java.io.*;

public class ServeurMono
{
    public static void main(String argv[])
    {

// --------------------------------------------------------------------------
// serveur      : objet serveur
// socketServeur : reference d'une socket du serveur vers le client
// sortie       : flux vers le client
// entree       : flux en provenance du client
// --------------------------------------------------------------------------
        ServerSocket serveur;

        Socket socketServeur;
        ObjectOutputStream sortie;
        ObjectInputStream entree;

// --------------------------------------------------------------------------
// ligne         : chaine de lecture ou d'ecriture dans les flux
// chaineOiseaux : concatenation des chaines envoyees par le client.
// nombreOiseaux : nombre de saisies effectuees par le client.
// --------------------------------------------------------------------------
        String ligne;
        String chaineOiseaux;
        int nombreOiseaux;

        chaineOiseaux = "";
        nombreOiseaux = 0;

        try
        {

// --------------------------------------------------------------------------
// Creation et lancement du serveur attache au port 8189.
// --------------------------------------------------------------------------
            serveur = new ServerSocket(8189);

            try
            {

// --------------------------------------------------------------------------
// Attente connexion client et creation de la socket.
// --------------------------------------------------------------------------
                socketServeur = serveur.accept();
                try
                {

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
                    sortie = 
                        new ObjectOutputStream(socketServeur.getOutputStream());
                    entree = 
                        new ObjectInputStream(socketServeur.getInputStream());

// --------------------------------------------------------------------------
// Message d'accueil pour le client.
// --------------------------------------------------------------------------
                    sortie.writeObject(
                        "Bonjour, entrez des noms d'oiseaux " +
                        "(Entrée pour finir) :\n" +
                        (nombreOiseaux + 1) + " -> ");

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
                catch (ClassNotFoundException e)
                {
                    System.out.println(e.getMessage());
                }
                finally
                {
                    socketServeur.close();
                }
            }
            finally
            {
                serveur.close();
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
